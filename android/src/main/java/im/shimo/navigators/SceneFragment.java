package im.shimo.navigators;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by jiang on 2019-11-19
 */

public class SceneFragment extends Fragment {


    private static final String TAG = "SceneFragment";
    protected Scene mSceneView;
    private Animation.AnimationListener mAnimationListener;

    private SceneFragment() {
    }

    @SuppressLint("ValidFragment")
    SceneFragment(Scene scene) {
        super();
        mSceneView = scene;
    }

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return mSceneView;
    }

    public Scene getScene() {
        return mSceneView;
    }


    @Nullable
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (nextAnim == 0) return super.onCreateAnimation(transit, enter, nextAnim);
        Animation animation = AnimationUtils.loadAnimation(requireContext(), nextAnim);
        if (mAnimationListener != null) {
            animation.setAnimationListener(mAnimationListener);
            mAnimationListener = null;
        }
        return animation;
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        mAnimationListener = animationListener;
    }

}
