package retrofit.longzhu.com.buidertoobar.navigation.imp;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Parameter;

import retrofit.longzhu.com.buidertoobar.R;

/**
 * 该类满足左中右导航条需求（目的：抽象所有的导航条左中右导航条公共功能）
 * 抽象某种场景下的导航条功能（左、中、右）
 */

public abstract class DefalutNavigation<P extends AbsNavigation.AbsNavigationParam> extends AbsNavigation<P> {
    public DefalutNavigation(P param) {
        super(param);
    }


    @Override
    public int bindLayoutId() {
        return R.layout.navigation_layout;
    }

    @Override
    public void build() {
        //千万不能忘记
        super.build();
        //动态的场景导航条布局
        LinearLayout leftLinearLayout = createChildLayout(1.0f);
        LinearLayout centerLinearLayout = createChildLayout(2.0f);
        LinearLayout rightLinearLayout = createChildLayout(1.0f);

        //回调定义好的规范方法
        bindParent(bindLeftLayoutId(), leftLinearLayout);
        bindParent(bindCenterLayoutId(), centerLinearLayout);
        bindParent(bindRightLayoutId(), rightLinearLayout);

        initLeftLayout(leftLinearLayout);
        initCenterLayout(centerLinearLayout);
        initRightLayout(rightLinearLayout);
    }

    /**
     * 绑定左边布局
     *
     * @return
     */
    public abstract int bindLeftLayoutId();

    /**
     * 绑定中间布局
     *
     * @return
     */
    public abstract int bindCenterLayoutId();

    /**
     * 绑定右边布局
     *
     * @return
     */
    public abstract int bindRightLayoutId();

    /**
     * 初始化左边布局
     *
     * @param parent
     */
    public void initLeftLayout(LinearLayout parent) {

    }

    /**
     * 初始化中间布局
     *
     * @param parent
     */
    public void initCenterLayout(LinearLayout parent) {
    }

    /**
     * 初始化右边布局
     *
     * @param parent
     */
    public void initRightLayout(LinearLayout parent) {
    }

    /**
     * 动态创建布局
     *
     * @return
     */
    private LinearLayout createChildLayout(float weight) {
        LinearLayout linearLayout = new LinearLayout(getParam().context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.weight = weight;
        linearLayout.setLayoutParams(layoutParams);
        //绑定父容器布局
        bindParent(linearLayout, (ViewGroup) getContentView());
        return linearLayout;
    }
}
