package st.teamcataly.lokalocalcustomer.root.loggedin.home.history

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HistoryRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: HistoryBuilder.Component
  @Mock internal lateinit var interactor: HistoryInteractor
  @Mock internal lateinit var view: HistoryView

  private var router: HistoryRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = HistoryRouter(view, interactor, component)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}

