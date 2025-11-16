package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentAABinding

class FragmentAA : Fragment() {
    private var _binding: FragmentAABinding? = null
    private val binding: FragmentAABinding
        get() = _binding ?: throw RuntimeException("FragmentAABinding == null")
    private var colorInt: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        colorInt = arguments?.getInt(COLOR)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAABinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFragmentAB.setOnClickListener(){
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFragmentA, FragmentAB.newInstance(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
        }
        colorInt?.let {
            binding.layoutFragmentAA.setBackgroundColor(it)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {

        private const val COLOR = "color"

        fun newInstance(color: Int): FragmentAA {
            return FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt(COLOR, color)
                }
            }
        }
    }
}
