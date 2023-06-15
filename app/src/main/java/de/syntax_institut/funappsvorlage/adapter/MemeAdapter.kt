package de.syntax_institut.funappsvorlage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import de.syntax_institut.funappsvorlage.R
import de.syntax_institut.funappsvorlage.data.datamodels.Meme
import de.syntax_institut.funappsvorlage.databinding.ListItemMemeBinding

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class MemeAdapter(
    private val dataset: List<Meme>
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

        // hole das memeItem aus dem dataset
        val meme = dataset[position]

        // baue eine URI aus der Bild URL
        val imgUri = meme.url.toUri().buildUpon().scheme("https").build()

        // lade das Bild mithilfe der URI in die ImageView und runde die Ecken ab
        holder.binding.ivMeme.load(imgUri) {
            error(R.drawable.ic_broken_image)
            transformations(RoundedCornersTransformation(10.0f))
        }

        // Meme-Titel. Wird gesetzt, wenn der Nutzer auf "speichern"-Button klickt.
        holder.binding.tvMeme.text = ""
        // Lade den Titel aus dem memeItem in das XML Element
        holder.binding.etTitle.setText(meme.name)
        // Setze einen Click Listener auf btnSave,
        // der den aktuellen Titel in das meme Objekt speichert
        holder.binding.btnSave.setOnClickListener {
            meme.name = holder.binding.etTitle.text.toString()
            holder.binding.tvMeme.text = holder.binding.etTitle.text.toString()
        }
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
