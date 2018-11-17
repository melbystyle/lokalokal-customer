package st.teamcataly.lokalocalcustomer.root.loggedin.shop.shopselection

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import io.reactivex.Observable
import st.teamcataly.lokalocalcustomer.R
import st.teamcataly.lokalocalcustomer.root.RootLifecycleEvent
import st.teamcataly.lokalocalcustomer.util.AndroidEventsService
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link ShopSelectionScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class ShopSelectionBuilder(dependency: ParentComponent) : ViewBuilder<ShopSelectionView, ShopSelectionRouter, ShopSelectionBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [ShopSelectionRouter].
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new [ShopSelectionRouter].
     */
    fun build(parentViewGroup: ViewGroup): ShopSelectionRouter {
        val view = createView(parentViewGroup)
        val interactor = ShopSelectionInteractor()
        val component = DaggerShopSelectionBuilder_Component.builder()
                .parentComponent(dependency)
                .view(view)
                .interactor(interactor)
                .build()
        return component.shopselectionRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): ShopSelectionView? {
        return inflater.inflate(R.layout.shopselection_rib, parentViewGroup, false) as ShopSelectionView
    }

    interface ParentComponent {
        fun shopSelectionListener(): ShopSelectionInteractor.Listener
        fun androidEventsService(): AndroidEventsService
        fun rootLifecycleStream(): Observable<RootLifecycleEvent>
    }

    @dagger.Module
    abstract class Module {

        @ShopSelectionScope
        @Binds
        internal abstract fun presenter(view: ShopSelectionView): ShopSelectionInteractor.ShopSelectionPresenter

        @dagger.Module
        companion object {

            @ShopSelectionScope
            @Provides
            @JvmStatic
            internal fun router(
                    component: Component,
                    view: ShopSelectionView,
                    interactor: ShopSelectionInteractor): ShopSelectionRouter {
                return ShopSelectionRouter(view, interactor, component)
            }
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @ShopSelectionScope
    @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
    interface Component : InteractorBaseComponent<ShopSelectionInteractor>, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: ShopSelectionInteractor): Builder

            @BindsInstance
            fun view(view: ShopSelectionView): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun shopselectionRouter(): ShopSelectionRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class ShopSelectionScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class ShopSelectionInternal
}
