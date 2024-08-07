package de.syntax_institut.funappsvorlage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.syntax_institut.funappsvorlage.data.model.Meme
import de.syntax_institut.funappsvorlage.databinding.ListItemMemeBinding

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class MemeAdapter(
    val dataset: List<Meme>
) : RecyclerView.Adapter<MemeAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(val binding: ListItemMemeBinding) :
        RecyclerView.ViewHolder(binding.root)

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ListItemMemeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val meme = dataset[position]

        holder.binding.tvMeme.text = meme.name
        holder.binding.ivMeme.load(meme.url.toUri().buildUpon().scheme("https").build())

        holder.binding.btnSave.setOnClickListener {
            val newTitle = holder.binding.etTitle.text.toString()
            holder.binding.tvMeme.text = newTitle
            meme.name = newTitle
        }
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
