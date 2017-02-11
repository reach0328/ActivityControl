#**Activity Control.**

Activity 라이프사이클 및 컴포넌트 다루기

## Activity LifeCycle

onCreate() -> onStart() -> onResume() -> Running(러닝은 상태없음) -> onPause() -> onStop() -> [onRestart()] onDestroy()

## Activity 호출하기

### 일반적인 호출
```java
    Intent intent = new Intent(this, ClassName.class);
    startActivity(intent)
```

### Activity 호출 후 값 다시 받기
* 호출하는 Activity
```java
    // 호출하는 측의 특정 위치를 구분하기 위한 상수
    public static final int REQ_CODE = 99;

    // 액티비티를 호출하는 함수
    public void callActivity(){
        Intent intent = new Intent(this, ClassName.class);
        startActivityForResult(intent, REQ_CODE);
    }

    // 호출되는 Activity 에서 사용되는 함수
    // requestCode = 호출측 구분 값
    // resultCode = 호출되는 측에서 처리결과를 알려주기 위해 정의된 값
    // intent = 결과 값
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

    }
```

* 호출되는 Activity
```java
    // 처리 결과코드 상수정의
    public static final int RESULT_OK = 0;
    public static final int RESULT_FAIL = 1;

    // 처리 완료 후 호출하는 함수
    private void callResult(){
        Intent intent = new Intent();
        intent.putExtra("result", " 처리된 값 ");

        // setResult 함수가 호출한 Activity의 onActivityResult 함수를 자동으로 호출한다.
        setResult(RESULT_OK, intent);

        // finish() 를 호출하여 현재 Activity 를 닫는다.
    }
```


--------------------------------------------------------
#**Theory**

![](http://postfiles11.naver.net/20110706_138/wmi1258_1309960439456ehSPB_PNG/1.png?type=w2)
###**Margin**
> - 속성은 뷰와 부모와의 간격을 지정한다. 근처에 형제뷰가 있으면 형제 뷰와의 간격도 마진만큼 떨어진다.
> - 패딩과 마찬가지로 상하좌우 지정할수 있으며 layout_marginLeft, layout_marginRight, layout_marginTop, layout_marginBottom 속성을 대입할 수 있다.



###**Padding**
> - 속성은 뷰와 내용물 간의 간격을 지정한다. 버트느이 경우 버튼 내부의 문자열과 버튼 테두리와의 간격이 패딩이며 레이아웃의 경우 차일드 위젯과의 간격이 패딩이다.
> - 상하좌우 다 설정할 수 있으며 paddingLeft, paddingTop, paddingRight, paddingBottom 속성에 각각 여백을 지정할 수있다.

![](https://i.stack.imgur.com/d4dhD.png)
###**Grid**
> - 격자 모양의 표에 차일드를 배치한다 


###**Linear**
> - 기본값은 수평정렬이다.
> - LinearLayout에 붙이는 순서대로 배치된다.
> - 별도의 지정이 없는한 뷰 사이의 공백이 없다.

####**intent를 활용한 화면전환**
```
Intent intent;
        switch (view.getId()){
            case R.id.btnGrid:
                //안드로이드 메이저 컴포넌트를 로드하기위에서는
                // intent를 통해서 로드할 컴포넌트를 지정해야한다
                intent = new Intent(this, GridActivity.class); // 대상이되는 컴포넌트
                startActivity(intent);
                break;
            case R.id.btnWidget:
                intent = new Intent(this, WidgetActivity.class);
                startActivity(intent);
                break;

```

####**[constraintLayout](http://kunny.github.io/lecture/ui/2016/05/22/constraint_layout_1/)**
> - 안드로이드 스튜디오 2.2의 향상된 레이아웃 디자이너와 함께 사용할 수 있는 레이아웃으로, 기존에 UI 요소를 배치하기 위해 사용했던 그 어느 레이아웃 보다 쉽고 빠르게 레이아웃을 구성할 수 있습니다.


####**[Listiner 만들기](http://blog.naver.com/PostView.nhn?blogId=netrance&logNo=110125312374&categoryNo=73&viewDate=&currentPage=1&listtype=0)**
> - 이벤트 리스너를 구현하는 익명 클래스를 액티비티 클래스 내에 정의
>```
OnXxxListener listener = new OnXxxListener()
{
     @Override
     void onXxx(View v)
     {
     }
};
>```
> - 프로젝트의 액티비티 클래스가 이벤트 리스너를 구현
> ```
> public class ActivityListeningToEvent extends Activity implements OnXxxListener {
>    // 편의상 다른 메소드들은 생략합니다.
> 
>   @Override
>    void onXxx(View v)
>    {
>   }
> }
> ```
> -  이벤트 리스너를 구현하는 별도의 클래스를 정의한 후 그것의 객체를 생성
> ```
> class OnXxxHandler implements OnXxxListener
{
    @Override
    void onXxx(View v)
    {
    }
}
> ```
>

####**App Components**
> 안드로이드는 App을 구성하는 4개의 핵심 컴포넌트가 있으며 이들은 각가 의 독립적인 LifeCycle에 의해서 실행된다. 왼쪽의 세개의 컴포넌트는 Intent에 의해, 나머지 한개는 Content Provider는 Resolver에 의해 실행된다.

####**Intent**
> - 하나의 컴포넌트가 다른 컴포넌트를 실행시킬 수 있는 매커니즘
> - 일반적으로 명시적 인텐트와 암묵적인텐트 두가지가 있으며
> - **Explicit Intent**(명시적 인텐트)
> - **Implicit Intent**(암묵적 인텐트)

![](http://thinkeapps.com/wp-content/uploads/2016/01/lcycle.png)
####**Activity Life Cycle**
> - [Entire Lifetime]
>   - 1. OnCreate()
> - [Visible Lifetime]
>  - 2. OnStart()
> - [Foreground Lifetime]
>  - 3. OnResume()
>  - 4. 실행
>  - 5. OnPause()
> - [Foreground Lifetime]
>  - 6. OnStop()
> - [Visible Lifetime]
>  - 7. onDestroy() 

