# controlLibrary
[![](https://jitpack.io/v/reyreyrey/controlLibrary.svg)](https://jitpack.io/#reyreyrey/controlLibrary)

</br>

##引入
<p>在项目的build.gradle中添加如下代码</p>
<pre>
  <code>
    allprojects{
      repositories {
          jcenter()
          maven { url "https://jitpack.io" }
      }
    }
  </code>
</pre>

<p>在Module的build.gradle中添加如下代码</p>
<pre>
  <code>
  //加号替换为jitpack版本号
    compile 'com.github.reyreyrey:controlLibrary:+'
  </code>
</pre>

##使用
<p>1.在项目的Application中添加以下代码</p>
<pre>
  <code>
    LibraryConfig config = new LibraryConfig.Build()
                              .with(this)
                              .appId("appid")//你的appid
                              .splashShowCaipiaoTime("2018-03-21 10:50:00")//在这个时间之前不显示彩票的启动页
                              .splashNormalRes(R.drawable.ic_splash_normal)//在配置的时间之前时显示的启动页图片
                              .splashCaipiaoRes(R.drawable.ic_splash_caipiao)//要显示的彩票启动页的图片
                              .build();
     ConrtolLibrary.init(config);
  </code>
</pre>

<p>2.在项目的启动页中添加以下代码</p>
<pre>
  <code>
    Control.control(this, new Control.OnControlListener(){
        @Override
        public void onStartCheck(){
        }
        
        @Override
        public void toMain(){
          startActivity(new Intent(activity, MainActivity.class));
        }
    });
  </code>
</pre>
