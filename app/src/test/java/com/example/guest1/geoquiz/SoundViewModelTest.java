package com.example.guest1.geoquiz;

import com.example.guest1.geoquiz.beatbox.BeatBox;
import com.example.guest1.geoquiz.beatbox.Sound;
import com.example.guest1.geoquiz.beatbox.SoundViewModel;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;

/*
 *  项目名: learn_android
 *  包名:   com.example.guest1.geoquiz
 *  文件名: SoundViewModelTest
 *  创建者: yuhaofeng
 *  描述:   todo
 */
public class SoundViewModelTest {

    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;


    //和大多数对象一样，测试类也需要创建对象实例以及它依赖的其他对象。为了避免为每一个
    //测试类写重复代码，JUnit提供了@Before这个注解。以@Before注解的包含公共代码的方法会在 所有测试之前运行一次。按照约定，所有单元测试类都要有以@Before注解的setUp()方法。
    @Before
    public void setUp() throws Exception{
        mBeatBox = Mockito.mock(BeatBox.class);
        mSound = new Sound("assetPath");
        mSubject = new SoundViewModel(mBeatBox);
        mSubject.setSound(mSound);
    }

    @Test
    public void exposesSoundNameAsTitle(){
        assertThat(mSubject.getTitle(), is(mSound.getName()));
    }

    @Test
    public void callsBeatBoxPlayOnButtonClicked() {
        mSubject.onButtonClicked();
        //调用verify(mBeatBox)方法就是说:“我要验证mBeatBox对象的某个方法是否调用了。”紧 跟的mBeatBox.play(mSound)方法是说:“验证这个方法是这样调用的。”所以，合起来就是说:
        //“验证以mSound作为参数，调用了mBeatBox对象的play(...)方法。”
        verify(mBeatBox).play(mSound);
    }

}
