package st.teamcataly.lokalocalcustomer.root

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import st.teamcataly.lokalocalcustomer.root.loggedin.LoggedInParentView
import st.teamcataly.lokalocalcustomer.root.loggedout.LoggedOutParentView

/**
 * Top level view for {@link RootBuilder.RootScope}.
 */
class RootView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : FrameLayout(context, attrs, defStyle), RootInteractor.RootPresenter, LoggedOutParentView, LoggedInParentView
