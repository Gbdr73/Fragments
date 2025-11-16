package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentBBBinding

class FragmentBB : Fragment() {
    private var _binding: FragmentBBBinding? = null
    private val binding: FragmentBBBinding
        get() = _binding ?: throw RuntimeException("FragmentAABinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSendColor.setOnClickListener(){
            parentFragmentManager.popBackStack()
            parentFragmentManager.setFragmentResult(
                KEY_BB,
                bundleOf(BK_COLOR to ColorGenerator.generateColor())
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val KEY_BB = "request_key_bb"
        val BK_COLOR = "color"
        fun newInstance(): FragmentBB{
            return FragmentBB()
        }
    }
}
