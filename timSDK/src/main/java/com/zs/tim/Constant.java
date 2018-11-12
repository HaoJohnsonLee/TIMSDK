package com.zs.tim;

public interface Constant {
    /**
     * 详情 =》 https://cloud.tencent.com/document/product/269/1608#2.4-http.E8.AF.B7.E6.B1.82.E6.96.B9.E5.BC.8F
     */
    interface URLs{
        /** 独立模式导入单个账号*/
        String ACCOUNT_IMPORT = "https://console.tim.qq.com/v4/im_open_login_svc/account_import";

        /** 批量账号导入*/
        String MULTIACCOUNT_INPORT = "https://console.tim.qq.com/v4/im_open_login_svc/multiaccount_import";

    }


    /**
     * 详情 =》 https://cloud.tencent.com/document/product/269/1500#.E6.A0.87.E9.85.8D.E8.B5.84.E6.96.99.E5.AD.97.E6.AE.B5
     */
    interface UserProfileTag{
        /** 昵称*/
        String IM_Nick = "Tag_Profile_IM_Nick";
        /** 性别*/
        String IM_Gender = "Tag_Profile_IM_Gender";
        /** 生日*/
        String IM_Birthday = "Tag_Profile_IM_BirthDay";
        /** 所在地*/
        String IM_Location = "Tag_Profile_IM_Location";
        /** 个性签名*/
        String IM_SelfSignature = "Tag_Profile_IM_SelfSignature";
        /** 加好友验证方式*/
        String IM_AllowType = "Tag_Profile_IM_AllowType";
        /** 语言*/
        String IM_Language = "Tag_Profile_IM_Language";
        /** 头像图片*/
        String IM_Image = "Tag_Profile_IM_Image";
        /** 消息设置  0 表示接受消息*/
        String IM_MsgSettings = "Tag_Profile_IM_MsgSettings";
        /** 管理员禁止其加好友标志*/
        String IM_AdminForbidType = "Tag_Profile_IM_AdminForbidType";
        /** 等级*/
        String IM_Level = "Tag_Profile_IM_Level";
        /** 角色*/
        String IM_Role = "Tag_Profile_IM_Role";
    }
}
