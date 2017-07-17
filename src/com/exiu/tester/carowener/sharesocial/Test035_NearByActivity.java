package com.exiu.tester.carowener.sharesocial;

import org.testng.annotations.Test;

import com.exiu.developer.BaseTestCase;

/**
 * Created by zn on 17/6/30.
 */
public class Test035_NearByActivity extends BaseTestCase {

    /**
     * zn
     * jz
     */
    @Test(priority = 1)
    public void 进行中_我的发布() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("进行中"));

        click(getId("我的发布"));
        compare("进行中_我的发布", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 2)
    public void 进行中_我的报名() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("进行中"));

        click(getId("我的报名"));
        compare("进行中_我的报名", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 3)
    public void 一起吃饭() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("一起吃饭"));

        compare("一起吃饭", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 4)
    public void 一起吃饭_智能排序() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("一起吃饭"));

        click(getId("排序"));
        click(getId("智能排序"));
        compare("一起吃饭_智能排序", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 5)
    public void 一起吃饭_由近到远() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("一起吃饭"));

        click(getId("排序"));
        click(getId("由近到远"));
        compare("一起吃饭_由近到远", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 6)
    public void 一起吃饭_时间全部() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("一起吃饭"));

        click(getId("时间"));
        click(getId("全部"));
        compare("一起吃饭_时间全部", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 7)
    public void 一起吃饭_时间今天() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("一起吃饭"));

        click(getId("时间"));
        click(getId("今天"));
        compare("一起吃饭_时间今天", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 8)
    public void 一起吃饭_城市() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("一起吃饭"));

        String parameter = getParameter("城市");
        String l1 = getParameter("l1");
        String l2 = getParameter("l2");
        sortFilter.sortFilter(parameter,null,l1,l2);
        compare("一起吃饭_城市", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 8)
    public void 我的发布_删除() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("进行中"));
        click(getId("我的发布"));

        click(getId("删除"));
        click(getId("删除确定"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 8)
    public void 我的发布_评论() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("进行中"));
        click(getId("我的发布"));

        click(getId("进入详情"));
        click(getId("详情评论"));
        autoInput();
        click(getId("详情评论发布"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 8)
    public void 我的发布_评论删除() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("进行中"));
        click(getId("我的发布"));

        click(getId("进入详情"));
        click(getId("删除评论"));
        click(getId("删除评论确定"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 9)
    public void 我的发布() {
        click(getId("共享社交"));
        click(getId("附近活动"));
        click(getId("进行中"));

        click(getId("进入发布"));
        click(getId("一起吃饭"));
        autoInput("发布");
        click(getId("弹出时间"));
        dateTimePicker.pickDateTime(getParameter("date"));
        click(getId("跳转地点"));
        click(getId("选择地点"));
        click(getId("发布提交"));
    }
}
