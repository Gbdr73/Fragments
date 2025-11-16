package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentBABinding

class FragmentBA : Fragment() {

    private var _binding: FragmentBABinding? = null
    private val binding: FragmentBABinding
        get() = _binding ?: throw RuntimeException("FragmentAABinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener(FragmentBB.KEY_BB, this){ key, bundle ->
            val color = bundle.getInt(FragmentBB.BK_COLOR)
            binding.layoutFragmentBA.setBackgroundColor(color)
        }
        if(binding.buttonFragmentBB != null){
            binding.buttonFragmentBB?.setOnClickListener(){
                parentFragmentManager.beginTransaction()
                    .replace(R.id.containerFragmentB, FragmentBB.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): FragmentBA{
            return FragmentBA()
        }
    }
}
