package retrofit.longzhu.com.buidertoobar.navigation.imp;

/**
 * 该类满足左中右导航条需求（目的：抽象所有的导航条左中右导航条公共功能）
 * 抽象某种场景下的导航条功能（左、中、右）
 */

public class DefalutNavigation<P extends AbsNavigation.AbsNavigationParam> extends AbsNavigation<P> {
    public DefalutNavigation(P param) {
        super(param);
    }

}
