package bg.softuni.exam.config;


import bg.softuni.exam.service.ClothesService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class ClothesMethodSecurityExpressionHandler extends
        DefaultMethodSecurityExpressionHandler {

    private final ClothesService clothesService;

    public ClothesMethodSecurityExpressionHandler(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
            Authentication authentication, MethodInvocation invocation) {
        OwnerSecurityExpressionRoot root = new OwnerSecurityExpressionRoot(authentication);

        root.setClothesService(clothesService);
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(new AuthenticationTrustResolverImpl());
        root.setRoleHierarchy(getRoleHierarchy());

        return root;

    }
}