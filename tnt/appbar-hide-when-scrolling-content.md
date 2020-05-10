### Cara membuat appbar hidden saat content di scoll ke atas dan muncul saat di scoll ke bawah

- di xml tag toolbar tambah "app:layout_scrollFlags="scroll|enterAlways|snap""
- di xml tag content tambah "app:layout_behavior="@string/appbar_scrolling_view_behavior""
