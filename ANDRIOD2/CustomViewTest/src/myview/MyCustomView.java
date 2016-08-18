package myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyCustomView extends View {
	Paint paint;
	
	
	public MyCustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint=new Paint();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		paint.setColor(Color.LTGRAY);
		
		//paint.setColor(Color.BLUE);
		paint.setColor(Color.rgb(100, 150, 130));
		canvas.drawCircle(100, 150, 50, paint);
			
	}
	
}
