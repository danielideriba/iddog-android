package br.android.iddog.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.android.iddog.R
import br.android.iddog.ui.BaseFragment
import br.android.iddog.utils.TAB_FOUR_DOG
import br.android.iddog.utils.TAB_ONE_DOG
import br.android.iddog.utils.TAB_THREE_DOG
import br.android.iddog.utils.TAB_TWO_DOG
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment: BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.configureViewModel()

        when(arguments?.getInt(ARG_SECTION_NUMBER)) {
            1 -> this.configureTabAndGet(TAB_ONE_DOG)
            2 -> this.configureTabAndGet(TAB_TWO_DOG)
            3 -> this.configureTabAndGet(TAB_THREE_DOG)
            4 -> this.configureTabAndGet(TAB_FOUR_DOG)
            else -> {
                this.configureTabAndGet(TAB_ONE_DOG)
            }
        }
    }

    private fun configureTabAndGet(dogBreed: String){
        viewModel.getOneBreedImage(dogBreed)
        viewModel.dataModel.observe(viewLifecycleOwner, Observer { results ->
            results?.let {
                Glide.with(this)
                    .load(it.message)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_launcher).error(R.drawable.not_found).diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(imgDogs)
            }
        })
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    private fun configureViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
}