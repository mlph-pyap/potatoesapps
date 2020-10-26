package com.monstarlabs.potatoesapps.ui.uielement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.monstarlabs.potatoesapps.R

class ListAdapter(private val myDataset: ArrayList<ContentData>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and

    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.uilement_home_list_item_view, parent, false)


        return ViewHolder(itemView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
          holder.item.findViewById<TextView>(R.id.project_name).text = myDataset[position].getProjectName()

        //?    holder.item.findViewById<ImageView>(R.id.user_avatar_image)
        //?        .setImageResource(listOfAvatars[position % listOfAvatars.size])

          holder.item.setOnClickListener {
        //?       val bundle = bundleOf(USERNAME_KEY to myDataset[position])

              holder.item.findNavController().navigate(
                  myDataset[position].getProjectID()
        //?          R.id.nav_ui_element_spinner_button,
              )
        //?          bundle)
         }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size


}