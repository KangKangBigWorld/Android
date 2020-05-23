# Android实验

## 学院：数信学院                     班级：17软闽

## 学号：116072017026          姓名：何亚康    

## Android记事本NotePad应用功能拓展

学习官方文档：
https://developer.android.google.cn/guide/topics/ui/declaring-layout.html
 学习文档中关于ConstraintLayout, LinearLayout和TableLayout的相关内容

## 实验内容

## 一、实现功能

### 1.NoteList中显示条目增加时间戳显示

![添加时间戳](https://img-blog.csdnimg.cn/20200515023910670.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)添加时间戳

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

### 2.添加笔记查询功能（根据标题查询）

![查询功能](https://img-blog.csdnimg.cn/20200515024406713.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)查询功能

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

###  

![查询功能](https://img-blog.csdnimg.cn/20200515024756571.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)查询功能

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

### 3.设置功能（初步实现）

![设置功能](https://img-blog.csdnimg.cn/20200515042915779.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)设置功能

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

![设置功能](https://img-blog.csdnimg.cn/20200515042931937.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)设置功能

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

### 4.优化删除功能

![删除功能](https://img-blog.csdnimg.cn/2020051502550735.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)删除功能

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

![全部删除功能](https://img-blog.csdnimg.cn/20200515042616814.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)全部删除功能

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)



##  二、项目代码分析以及源码

### 1.NoteList中显示条目增加时间戳显示

```Kotlin
 public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_HOME){
            return true;
        }
        else if (keyCode == KeyEvent.KEYCODE_BACK){
            autoSetMessage();//自动保存
            setResult(RESULT_OK, intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void autoSetMessage(){
        if(openMode == 4){
            if(et.getText().toString().length() == 0){
                intent.putExtra("mode", -1); //没有事情发生
            }
            else{
                intent.putExtra("mode", 0); // 新建一个笔记
                intent.putExtra("content", et.getText().toString());
                intent.putExtra("time", dateToStr());//保存时间
                intent.putExtra("tag", tag);
            }
        }
        else {
            if (et.getText().toString().equals(old_content) && !tagChange)
                intent.putExtra("mode", -1); // 不编辑
            else {
                intent.putExtra("mode", 1); //edit the content
                intent.putExtra("content", et.getText().toString());
                intent.putExtra("time", dateToStr());
                intent.putExtra("id", id);
                intent.putExtra("tag", tag);
            }
        }
    }

    public String dateToStr(){//将数据转换成一个时间戳格式的显示出来
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

#### NoteList中显示条目增加时间戳显示：

在`xml`中添加一个用于显示时间戳的TextView<br>

```java
<TextView
            android:id="@+id/time"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:paddingLeft="5dip"
            android:textColor="#000000"
            />
```

已知数据库定义中已存在修改时间和创建时间的项：<br>

```
db.execSQL("CREATE TABLE " + NotePad.Notes.TABLE_NAME + " ("
                   + NotePad.Notes._ID + " INTEGER PRIMARY KEY,"
                   + NotePad.Notes.COLUMN_NAME_TITLE + " TEXT,"
                   + NotePad.Notes.COLUMN_NAME_NOTE + " TEXT,"
                   + NotePad.Notes.COLUMN_NAME_CREATE_DATE + " INTEGER,"
                   + NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE + " INTEGER,"
                   + ");");
```

使用修改时间为时间戳显示，在NoteList中找到PROJECTION添加一个元素<br>

```java
private static final String[] PROJECTION = new String[] {
            NotePad.Notes._ID, // 0
            NotePad.Notes.COLUMN_NAME_TITLE, // 1
            NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE,//添加该行
    };
```

修改dataColumns,viewIDs添加时间，然后用Cursor从数据库中取出数据<br>

```java
private String[] dataColumns = { NotePad.Notes.COLUMN_NAME_TITLE ,
                    NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE
} ;
// The view IDs that will display the cursor columns, initialized to the TextView in
private int[] viewIDs = { android.R.id.text1,R.id.text1_time };
```

修改时间的显示方式:在NotePadProvider中显示的`insert方法`和NoteEditor中的`updateNote`方法中修改`创建时间`和`修改时间`的格式<br>

```java
public String dateToStr(){//将数据转换成一个时间戳格式的显示出来
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
```

```java
 intent.putExtra("time", dateToStr());//保存时间
```

### 2.添加笔记查询功能（根据标题查询）

```Kotlin
@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mContext.setTheme(R.style.DayTheme);
        View v = View.inflate(mContext, R.layout.note_layout, null);
        TextView tv_content = (TextView)v.findViewById(R.id.tv_content);
        TextView tv_time = (TextView)v.findViewById(R.id.tv_time);

        //Set text for TextView
        String allText = noteList.get(position).getContent();
        /*if (sharedPreferences.getBoolean("noteTitle" ,true))
            tv_content.setText(allText.split("\n")[0]);*/
        tv_content.setText(allText);
        tv_time.setText(noteList.get(position).getTime());

        //Save note id to tag
        v.setTag(noteList.get(position).getId());

        return v;
    }

    @Override
    public Filter getFilter() {
        if (mFilter ==null){
            mFilter = new MyFilter();
        }
        return mFilter;
    }

    class MyFilter extends Filter {
        //我们在performFiltering(CharSequence charSequence)这个方法中定义过滤规则
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults result = new FilterResults();
            List<Note> list;
            if (TextUtils.isEmpty(charSequence)) {//当过滤的关键字为空的时候，我们则显示所有的数据
                list = backList;
            } else {//否则把符合条件的数据对象添加到集合中
                list = new ArrayList<>();
                for (Note note : backList) {
                    if (note.getContent().contains(charSequence)) {
                        list.add(note);
                    }

                }
            }
            result.values = list; //将得到的集合保存到FilterResults的value变量中
            result.count = list.size();//将集合的大小保存到FilterResults的count变量中

            return result;
        }
        //在publishResults方法中告诉适配器更新界面
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            noteList = (List<Note>)filterResults.values;
            if (filterResults.count>0){
                notifyDataSetChanged();//通知数据发生了改变
            }else {
                notifyDataSetInvalidated();//通知数据失效
            }
        }
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

### 3.设置功能（初步实现）

setting_layout.xml里面找找。

### 4.优化删除功能

**部分删除**

```Kotlin
@Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.delete:
                new AlertDialog.Builder(EditActivity.this)
                        .setMessage("您确定删除吗？")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (openMode == 4){ // new note
                                    intent.putExtra("mode", -1);
                                    setResult(RESULT_OK, intent);
                                }
                                else { // existing note
                                    intent.putExtra("mode", 2);
                                    intent.putExtra("id", id);
                                    setResult(RESULT_OK, intent);
                                }
                                finish();
                            }
                        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

**全部删除**

```Kotlin
@Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_clear:
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("您确定删除全部吗？")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbHelper = new NoteDatabase(context);
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                db.delete("notes", null, null);
                                db.execSQL("update sqlite_sequence set seq=0 where name='notes'");
                                refreshListView();
                            }
                        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## 三、后期计划

** UI美化**

![img](https://img-blog.csdnimg.cn/20200515022857345.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)


** 更改记事本的背景**

![img](https://img-blog.csdnimg.cn/2020051502303719.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)


** 导出笔记，笔记的云备份和恢复
 添加代办功能
 记事本的设置的功能
 笔记分类**

![img](https://img-blog.csdnimg.cn/20200515022933228.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)


** 支持多种资源，如保存图片、语音、视频等（参考印象笔记）
 语音搜索？
 笔记便签**

![img](https://img-blog.csdnimg.cn/20200515023013184.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

![img](https://img-blog.csdnimg.cn/20200515023130609.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODY4MTA4,size_16,color_FFFFFF,t_70)

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## 四、参考资料

### 1.[彩色笔记](http://www.cncrk.com/downinfo/100168.html) 2.[印象笔记]() 3.[数据存储的基本知识](https://developer.android.google.cn/guide/topics/data/data-storage) [使用SQLite数据库进行数据存储]()  4.ContentProvider: ContentProvider用于数据共享，如果你不提供数据共享机制，可以不使用 [ https://developer.android.google.cn/guide/topics/providers/content-provider-basics]() [ https://developer.android.google.cn/guide/topics/providers/content-provider-creating]()

作者：何亚康

原文地址：https://mp.csdn.net/console/editor/html/106132979