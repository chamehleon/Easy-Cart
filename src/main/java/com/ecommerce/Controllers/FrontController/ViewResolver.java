package com.ecommerce.Controllers.FrontController;



public class ViewResolver {
    String view;
    ResolveAction resolveAction;

    public ViewResolver() {
    }

    public ViewResolver(String view) {
        this.view = view;
        resolveAction = ResolveAction.FORWARD;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ResolveAction getResolveAction() {
        return resolveAction;
    }

    public void setResolveAction(ResolveAction resolveAction) {
        this.resolveAction = resolveAction;
    }

    public void forward(String view) {
        setView(view);
        resolveAction = ResolveAction.FORWARD;
    }

    public void redirect(String view) {
        setView(view);
        resolveAction = ResolveAction.REDIRECT;
    }

    public void plainText(final String view) {
        setView(view);
        resolveAction = ResolveAction.PLAIN_TEXT;
    }

    public void JSON(String view) {
        setView(view);
        resolveAction = ResolveAction.JSON;
    }


}
