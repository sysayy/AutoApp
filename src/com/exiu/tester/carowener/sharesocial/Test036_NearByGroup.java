package com.exiu.tester.carowener.sharesocial;

import com.exiu.developer.BaseTestCase;
import org.testng.annotations.Test;

/**
 * Created by zn on 17/6/30.
 */
public class Test036_NearByGroup extends BaseTestCase {

    /**
     * zn
     * jz
     */
    @Test(priority = 1)
    public void 附近群组() {
        click(getId("共享社交"));
        click(getId("附近群组"));
        compare("附近群组", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 2)
    public void 附近群组_城市() {
        click(getId("共享社交"));
        click(getId("附近群组"));
        compare("附近群组_城市", getId("table"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 3)
    public void 分类找群() {
        click(getId("共享社交"));
        click(getId("附近群组"));
        click(getId("分类找群"));
        compare("分类找群", getId("table"), getId("cell"));
    }

    /**
     * jz
     * zn
     */
    @Test(priority = 4)
    public void 发布群组() {
        click(getId("共享社交"));
        click(getId("附近群组"));
        click(getId("发布群组"));
        click(getId("群组种类"));
        click(getId("种类下一步"));
        if (isAndroid){
            photo.takePhoto(getId("头像选择"));
        }else {
            click(getId("头像选择"));
            click(getId("上传头像选择"));
            click(getId("选择图片"));
            click(getId("图片完成"));
            click(getId("截取完成"));
            click(getId("图片提交"));
        }

        click(getId("我的等级"));
        click(getId("选择等级"));
        sendKeys(getId("群名称"), "test group");

        if (!isAndroid) {
            click(getId("城市"));
            String cityParam = getParameter("城市选择");
            citySelector.selectCity(cityParam);
            click(getId("地址"));
            click(getId("地址列表选择"));
        }
        click(getId("群组下一步"));
        sendKeys(getId("填写资料"), "auto test 填写资料");
        click(getId("群组完成"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 3)
    public void 群主页_全部成员() {
        click(getId("共享社交"));
        click(getId("附近群组"));
        click(getId("进群主页"));
        click(getId("查看全部成员"));
        compare("群主页_全部成员", getId("table1"), getId("cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 3)
    public void 群主页_推荐好友() {
        click(getId("共享社交"));
        click(getId("附近群组"));
        click(getId("进群主页"));
        click(getId("添加成员"));
        click(getId("推荐好友"));
        compare("群主页_推荐好友", getId("table2"), getId("添加好友cell"));
    }

    /**
     * zn
     * jz
     */
    @Test(priority = 3)
    public void 群主页_我的好友() {
        click(getId("共享社交"));
        click(getId("附近群组"));
        click(getId("进群主页"));
        click(getId("添加成员"));
        click(getId("我的好友"));
        compare("群主页_我的好友", getId("table2"), getId("添加好友cell"));
    }
}
