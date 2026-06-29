import org.apache.ofbiz.entity.GenericValue
import org.apache.ofbiz.entity.util.EntityQuery
import org.apache.ofbiz.service.ServiceUtil
import org.apache.ofbiz.entity.condition.EntityCondition
import org.apache.ofbiz.entity.condition.EntityOperator

def findProduct() {
    Map result = ServiceUtil.returnSuccess()
    String productId = context.productId
    String internalName = context.internalName
    String productCategoryId = context.productCategoryId

    List conditions = []
    if (productId) {
        conditions.add(EntityCondition.makeCondition("productId", EntityOperator.EQUALS, productId))
    }
    if (internalName) {
        conditions.add(EntityCondition.makeCondition("internalName", EntityOperator.LIKE, "%" + internalName + "%"))
    }
    if (productCategoryId) {
        conditions.add(EntityCondition.makeCondition("productCategoryId", EntityOperator.EQUALS, productCategoryId))
    }

    List<GenericValue> products = []
    if (conditions) {
        products = EntityQuery.use(delegator).from("FindProductView")
                .where(EntityCondition.makeCondition(conditions, EntityOperator.AND))
                .queryList()
    } else {
        products = EntityQuery.use(delegator).from("FindProductView").queryList()
    }

    result.productList = products
    return result
}

def createProduct() {
    Map result = ServiceUtil.returnSuccess()
    String internalName = context.internalName
    
    List<GenericValue> existing = EntityQuery.use(delegator).from("Product")
            .where("internalName", internalName)
            .queryList()
            
    if (existing) {
        return ServiceUtil.returnError("Product with name " + internalName + " already exists.")
    }
    
    String productId = delegator.getNextSeqId("Product")
    result.productId = productId
    return result
}

def updateProduct() {
    Map result = ServiceUtil.returnSuccess()
    return result
}

def assocProductToVirtual() {
    Map result = ServiceUtil.returnSuccess()
    return result
}

def updateProductVariant() {
    Map result = ServiceUtil.returnSuccess()
    return result
}