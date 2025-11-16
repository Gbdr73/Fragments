package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentABBinding

class FragmentAB : Fragment() {
    private var _binding: FragmentABBinding? = null
    private val binding: FragmentABBinding
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
        _binding = FragmentABBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        colorInt?.let {
            binding.layoutFragmentAB.setBackgroundColor(it)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        private const val COLOR = "color"
        fun newInstance(color: Int): FragmentAB {
            return FragmentAB().apply {
                arguments = Bundle().apply {
                    putInt(COLOR, color)
                }
            }
        }
    }
}
