package de.syntax_institut.funappsvorlage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.funappsvorlage.R

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class MemeAdapter(
    private val dataset: List<Any>
) : RecyclerView.Adapter<MemeAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivMeme: ImageView = itemView.findViewById(R.id.ivMeme)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val btnSave: Button = itemView.findViewById(R.id.btnSave)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_meme, parent, false)

        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // hole das memeItem aus dem dataset
        // TODO

        // baue eine URI aus der Bild URL
        // TODO

        // lade das Bild mithilfe der URI in die ImageView und runde die Ecken ab
        // TODO

        // Lade den Titel aus dem memeItem in das XML Element
        // TODO

        // Setze einen Click Listener auf btnSave,
        // der den aktuellen Titel in das meme Objekt speichert
        // TODO
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
