import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : Activity() {

    private lateinit var radiusEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var densityEditText: EditText
    private lateinit var volumeCheckBox: CheckBox
    private lateinit var massCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radiusEditText = findViewById(R.id.radiusEditText)
        heightEditText = findViewById(R.id.heightEditText)
        densityEditText = findViewById(R.id.densityEditText)
        volumeCheckBox = findViewById(R.id.volumeCheckBox)
        massCheckBox = findViewById(R.id.massCheckBox)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuInput -> {
                showInputDialog()
                true
            }
            R.id.menuWork -> {
                showWorkDialog()
                true
            }
            R.id.menuExit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showInputDialog() {
        val dialogView = layoutInflater.inflate(R.layout.input_dialog, null)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
            .setTitle("Input")
            .setPositiveButton("Save") { _, _ ->
                val radius = radiusEditText.text.toString().toDouble()
                val height = heightEditText.text.toString().toDouble()
                val density = densityEditText.text.toString().toDouble()
                val volumeSelected = volumeCheckBox.isChecked
                val massSelected = massCheckBox.isChecked

                // Perform calculations or save the input data as needed
            }
            .setNegativeButton("Cancel", null)
        builder.create().show()
    }

    private fun showWorkDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Work")
            .setMessage("Results will be shown here.")
            .setPositiveButton("OK", null)
        builder.create().show()
    }
}