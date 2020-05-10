import android.util.Patterns
import android.widget.EditText
import java.util.regex.Pattern

fun String.isAnEmailAddress() : Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun EditText.textString(): String = this.text.toString()

fun String.validPhoneNumber(): Boolean{
    return if (!Pattern.matches("[a-zA-Z]+", this)) !(this.length < 6 || this.length > 13) else  false
}

