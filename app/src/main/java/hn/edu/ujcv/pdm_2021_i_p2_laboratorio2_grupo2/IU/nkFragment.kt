package hn.edu.ujcv.pdm_2021_i_p2_laboratorio2_grupo2.IU

import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hn.edu.ujcv.pdm_2021_i_p2_laboratorio2_grupo2.R
import kotlinx.android.synthetic.main.nk_fragment.*

class nkFragment : Fragment() {

    companion object {
        fun newInstance() = nkFragment()
    }

    private lateinit var viewModel: NkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nk_fragment, container, false)
    }

    interface OnFragmentInteractionListener{
        fun onFragmentInteraction(uri: Uri)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NkViewModel::class.java)

        btn_IN.setOnClickListener {
            textView.text = viewModel.getResultado().toString()

        }
    }

}