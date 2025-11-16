package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentABinding

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding: FragmentABinding
        get() = _binding ?: throw RuntimeException("FragmentABinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount <= 0){
                    requireActivity().finish()
                } else {
                    childFragmentManager.popBackStack()
                }
            }
        })
        binding.buttonFragmentAA.setOnClickListener(){
            childFragmentManager.popBackStack()
            childFragmentManager.beginTransaction()
                .replace(R.id.containerFragmentA, FragmentAA.newInstance(ColorGenerator.generateColor()))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): FragmentA{
            return FragmentA()
        }
    }
}
