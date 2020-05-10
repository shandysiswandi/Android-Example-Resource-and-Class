import android.content.Context
import android.content.ContextWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView

fun ImageView.loadImageWithGlide(imgUrl: String?){
    imgUrl?.let {
        Glide.with(this.context)
            .load(imgUrl)
            .into(this)
    }
}

fun Context.getParentActivity(): AppCompatActivity? {
    return when (this) {
        is AppCompatActivity -> this
        is ContextWrapper -> this.baseContext.getParentActivity()
        else -> null
    }
}

fun ViewGroup.inflate(layout:Int): View {
    return LayoutInflater.from(context).inflate(layout,this, false)
}

fun Context.inflateView(layout: Int): View {
    val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    return inflater.inflate(layout, null)
}

fun Context.inflateCustomView(layout: Int, viewGroup: ViewGroup?) {
    val inflater= this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    inflater.inflate(layout, viewGroup, true)
}

fun ViewGroup.setLayoutChangeAnim(layoutChange: Int){
    this.layoutTransition.enableTransitionType(layoutChange)
}

fun BottomNavigationView.getSelectedItem() = menu.findItem(selectedItemId)!!

fun BottomNavigationView.getMenuItem(id: Int) = menu.findItem(id)!!

fun View.getParentActivity(): AppCompatActivity? = this.context.getParentActivity()