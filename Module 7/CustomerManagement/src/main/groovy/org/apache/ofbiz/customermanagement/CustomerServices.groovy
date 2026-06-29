import org.apache.ofbiz.entity.GenericValue
import org.apache.ofbiz.entity.util.EntityQuery
import org.apache.ofbiz.service.ServiceUtil
import org.apache.ofbiz.entity.condition.EntityCondition
import org.apache.ofbiz.entity.condition.EntityOperator

def findCustomer() {
    Map result = ServiceUtil.returnSuccess()
    String emailAddress = context.emailAddress
    String firstName = context.firstName
    String lastName = context.lastName

    List conditions = []
    if (emailAddress) {
        conditions.add(EntityCondition.makeCondition("infoString", EntityOperator.LIKE, "%" + emailAddress + "%"))
    }
    if (firstName) {
        conditions.add(EntityCondition.makeCondition("firstName", EntityOperator.LIKE, "%" + firstName + "%"))
    }
    if (lastName) {
        conditions.add(EntityCondition.makeCondition("lastName", EntityOperator.LIKE, "%" + lastName + "%"))
    }
    conditions.add(EntityCondition.makeCondition("contactMechPurposeTypeId", EntityOperator.EQUALS, "PRIMARY_EMAIL"))

    List<GenericValue> customers = EntityQuery.use(delegator).from("FindCustomerView")
            .where(EntityCondition.makeCondition(conditions, EntityOperator.AND))
            .queryList()

    result.customerList = customers
    return result
}

def createCustomer() {
    Map result = ServiceUtil.returnSuccess()
    String emailAddress = context.emailAddress
    
    List<GenericValue> existing = EntityQuery.use(delegator).from("FindCustomerView")
            .where("infoString", emailAddress, "contactMechPurposeTypeId", "PRIMARY_EMAIL")
            .queryList()
            
    if (existing) {
        return ServiceUtil.returnError("Customer with email " + emailAddress + " already exists.")
    }
    
    String partyId = delegator.getNextSeqId("Party")
    result.partyId = partyId
    return result
}

def updateCustomer() {
    Map result = ServiceUtil.returnSuccess()
    String emailAddress = context.emailAddress
    
    List<GenericValue> existing = EntityQuery.use(delegator).from("FindCustomerView")
            .where("infoString", emailAddress, "contactMechPurposeTypeId", "PRIMARY_EMAIL")
            .queryList()
            
    if (!existing) {
        return ServiceUtil.returnError("Customer with email " + emailAddress + " does not exist.")
    }
    
    result.partyId = existing[0].partyId
    return result
}

def createCustomerRelationship() {
    Map result = ServiceUtil.returnSuccess()
    return result
}

def updateCustomerRelationship() {
    Map result = ServiceUtil.returnSuccess()
    return result
}