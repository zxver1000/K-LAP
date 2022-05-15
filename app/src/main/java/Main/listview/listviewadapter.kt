package Main.listview

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vision_exam.MainActivity
import com.example.vision_exam.R


class MyRecyclerView(items: ArrayList<ItemCard>) : RecyclerView.Adapter<MyRecyclerView.MyViewHolder>() {


    var items = items
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var ivProfile: ImageView = itemView.findViewById(R.id.ivProfile)
        var title: TextView = itemView.findViewById(R.id.title)
        var subtitle: TextView = itemView.findViewById(R.id.subtitle)

        fun bind(position: Int) {
            ivProfile.setImageResource(items[position].imageRes)
            ivProfile.setBackgroundResource(items[position].backgroundRes)
            title.text = items[position].name
            subtitle.text = items[position].subtitle

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.listview_item, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
        var button: Button =holder.itemView.findViewById(R.id.button)
        val item=arrayOf("8","10","12","15","20")
        var selecitem:String?=null
        button.setOnClickListener{

            val builder = AlertDialog.Builder(holder.itemView?.context)
            builder.setTitle("Set the number of repetitions per set")
                .setSingleChoiceItems(item,-1){
                        dialog,which-> selecitem=item[which]
            }
                .setPositiveButton("Start",DialogInterface.OnClickListener{
                    dialog,id->
                    val intent = Intent(holder.itemView?.context, MainActivity::class.java)
                    ContextCompat.startActivity(holder.itemView.context,intent,null)
                }).setNegativeButton("Cancle",DialogInterface.OnClickListener{
                    dialog,id->
                })



            builder.show()

            //val intent = Intent(holder.itemView?.context, MainActivity::class.java)
            //ContextCompat.startActivity(holder.itemView.context,intent,null)
        }
    }
    override fun getItemCount(): Int = items.size fun addPerson(item: ItemCard) {
        items.add(item)
    }


}


