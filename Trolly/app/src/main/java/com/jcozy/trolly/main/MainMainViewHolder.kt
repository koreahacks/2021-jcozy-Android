
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.MainMainData
import kotlin.properties.Delegates

class MainMainViewHolder(itemView: View/*, val itemClick:(MainMainData, View) -> Unit*/): RecyclerView.ViewHolder(itemView){

    var mainmainIdx by Delegates.notNull<Int>()
    var mainImg : ImageView = itemView.findViewById(R.id.main_img)
    var name : TextView = itemView.findViewById(R.id.tv_main_name)
    var level : TextView = itemView.findViewById(R.id.tv_main_lv)
    var people : TextView = itemView.findViewById(R.id.tv_main_people)

    fun bind(myData : MainMainData){
        mainmainIdx = myData.mainmainIdx
        Glide.with(itemView).load(myData.mainImg).into(mainImg)
        name.text = myData.name
        level.text = "Lv" + myData.level.toString()
        people.text = myData.people.toString() + "명 참여"

        /* itemView.setOnClickListener { itemClick(myData, itemView) }*/
    }

}