package ch.ost.rj.mge.miniprojekt.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import ch.ost.rj.mge.miniprojekt.R
import ch.ost.rj.mge.miniprojekt.model.Recipe
import ch.ost.rj.mge.miniprojekt.model.RecipeRepository
import com.google.android.material.textfield.TextInputEditText
import java.io.File
import java.io.FileOutputStream


class AddRecipeActivity : AppCompatActivity() {
    private lateinit var titleInputText: TextInputEditText
    private lateinit var descriptionInputText: TextInputEditText

    companion object {
        const val PICK_IMAGE_CODE = 1
    }

    private fun saveRecipe() {
        val name = findViewById<TextInputEditText>(R.id.recipe_name_input)
        val description = findViewById<TextInputEditText>(R.id.recipe_description_input)
        val imagePath = findViewById<TextView>(R.id.image_path)
        RecipeRepository.addRecipe(
            Recipe(
                name.text.toString(),
                description.text.toString(),
                imagePath.text.toString()
            )
        )
    }

    private fun updateSaveButton() {
        val isValid: (input: TextInputEditText) -> Boolean =
            { input -> input.text.toString().isNotEmpty() }

        val allowSave = isValid(titleInputText) && isValid(descriptionInputText)
        findViewById<Button>(R.id.save_recipe_button).isEnabled = allowSave
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        titleInputText = findViewById(R.id.recipe_name_input)
        titleInputText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                updateSaveButton()
            }
        })

        descriptionInputText = findViewById(R.id.recipe_description_input)
        descriptionInputText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                updateSaveButton()
            }
        })

        val addImageButton = findViewById<Button>(R.id.add_image_button)

        addImageButton.setOnClickListener { pickImage() }

        val saveButton = findViewById<Button>(R.id.save_recipe_button)
        saveButton.setOnClickListener {
            saveRecipe()
            Toast.makeText(applicationContext, "Rezept wurde gespeichert", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"

        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, PICK_IMAGE_CODE)
        } else {
            Toast.makeText(
                applicationContext,
                "Keine passende Anwendung installiert",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun copyImageToInternalStorage(uri: Uri, name: String) {
        val file = File(filesDir, "/$name")
        val outputStream = FileOutputStream(file)

        val bytesArr = baseContext.contentResolver.openInputStream(uri)?.use { it.buffered().readBytes() }
        outputStream.write(bytesArr)

        outputStream.close()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_CODE && resultCode == RESULT_OK) {
            val uri: Uri? = data?.data

            if (uri != null) {
                val name = getNameOfFile(uri)
                copyImageToInternalStorage(uri, name)

                val imageView = findViewById<ImageView>(R.id.image)
                imageView.setImageURI(uri)

                val pathTextView = findViewById<TextView>(R.id.image_path)
                val path = filesDir.path + "/" + name
                pathTextView.text = path

                findViewById<Button>(R.id.add_image_button).isVisible = false
            }
        }
    }

    private fun getNameOfFile(uri: Uri): String {
        val returnCursor = contentResolver.query(uri, null, null, null, null)!!
        val nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)

        returnCursor.moveToFirst()
        val name = returnCursor.getString(nameIndex)
        returnCursor.close()

        return name
    }
}
