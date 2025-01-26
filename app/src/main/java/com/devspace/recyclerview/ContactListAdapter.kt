package com.devspace.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

// Adapatação entre o dataclass e o item_list

class ContactListAdapter: ListAdapter<Contact, ContactListAdapter.ContactViewHolder>(ContactDiffUtils()) {

    private lateinit var onClickListener: (Contact) -> Unit



    //Criar um view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ContactViewHolder(view)
    }
    // bind - atrelar o dado com a UI views
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact, onClickListener)
    }

    fun setOnClickListener(onClick: (Contact) -> Unit){
        onClickListener = onClick

    }

    // view holder = view que segura os dados
    class ContactViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        private val tvName = view.findViewById<TextView>(R.id.tv_name)
        private val tvNumber = view.findViewById<TextView>(R.id.tv_number)
        private val image_view = view.findViewById<ImageView>(R.id.img_vw)

        fun bind(contact: Contact, onClick: (Contact) -> Unit){
            tvName.text = contact.name
            tvNumber.text = contact.number
            image_view.setImageResource(contact.icon)

            view.setOnClickListener{
                onClick.invoke(contact)
            }
        }
    }
    // compara a diferença quando a nossa lista é atualizada
    class  ContactDiffUtils : DiffUtil.ItemCallback<Contact>(){
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name
        }

    }


}