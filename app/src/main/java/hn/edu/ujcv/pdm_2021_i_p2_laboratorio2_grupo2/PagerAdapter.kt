package hn.edu.ujcv.pdm_2021_i_p2_laboratorio2_grupo2
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class PagerAdapter (fm: FragmentManager, private var tabCount:Int):
FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0-> return RegistrarAlumno()
            1-> return RegistrarClase()
            2-> return RealizarMatricula()
            3-> return IngresarNotas()
            4-> return EnviarMatricula()
            5-> return EnviarNotas()
            else -> return RegistrarAlumno()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}