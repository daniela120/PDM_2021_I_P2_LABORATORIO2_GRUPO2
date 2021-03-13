package hn.edu.ujcv.pdm_2021_i_p2_laboratorio2_grupo2

import android.R
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.os.persistableBundleOf
import androidx.fragment.app.Fragment
import hn.edu.ujcv.pdm_2021_i_p2_laboratorio2_grupo2.R.*
import kotlinx.android.synthetic.main.fragment_realizar_matricula.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RealizarMatricula.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("UNREACHABLE_CODE")
class RealizarMatricula : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val spinner: Spinner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val let = arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        getAsignatura()


    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(layout.fragment_realizar_matricula, container, false)


        val spinner = view.findViewById()
        val lista = resources.getStringArray(array.asignatus)


        val adaptador = (ArrayAdapter<String>(requireContext(), R.layout.simple_spinner_dropdown_item, lista))

        spinner.adapter = adaptador

        spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                txvSe1.text = "No ha seleccionado ninguna opcion"

            }

            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                txvSe1.text = lista[position].toString()
            }

        }
    }




    interface OnFragmentInteractionListener{
        fun onFragmentInteraction(uri: Uri)
    }


    fun getAsignatura() {
        val bundle = persistableBundleOf()
        val trans = bundle?.get("trans")
        txvSe1.text = getString(string.seleccion, trans)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RealizarMatricula.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RealizarMatricula().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}