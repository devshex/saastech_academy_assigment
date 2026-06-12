/**
 * PersonServices.groovy
 * Component  : party
 * Called by  : party.PersonService.create#Person  (via <script location="..."/>)
 *
 * Moqui automatically injects into this script's binding:
 *   - ec          → ExecutionContext (access to entity, logger, message facades)
 *   - context     → Map of all in-parameters (partyId, firstName, lastName, dateOfBirth, ...)
 *   - partyId     → value of the in-parameter directly available as a variable
 *   - firstName   → same
 *   - lastName    → same
 *   - dateOfBirth → same (may be null if not provided)
 *
 * To return an out-parameter, simply assign to its name (responseMessage = "...").
 * Moqui reads it back from the binding after the script completes.
 */

// ─────────────────────────────────────────────────────────────────────────────
// STEP 1: Manual validation (defence-in-depth on top of XML required="true")
// ─────────────────────────────────────────────────────────────────────────────
// Although Moqui's Service Facade already rejects missing required parameters
// before reaching this script, we validate here explicitly as the assignment
// requires demonstrating validation logic in Groovy.

if (!partyId) {
    ec.message.addError("Validation failed: partyId is required.")
    return
}
if (!firstName) {
    ec.message.addError("Validation failed: firstName is required.")
    return
}
if (!lastName) {
    ec.message.addError("Validation failed: lastName is required.")
    return
}

// ─────────────────────────────────────────────────────────────────────────────
// STEP 2: Verify the Party (hub record) exists before creating the Person (spoke)
// ─────────────────────────────────────────────────────────────────────────────
// A Person cannot exist without a parent Party record.
// ec.entity is the Entity Facade — no JDBC/DataSource setup needed.
// Moqui internally uses the configured JDBC connection pool (HikariCP).

def existingParty = ec.entity.find("tutorial.party.Party")
        .condition("partyId", partyId)
        .one()

if (existingParty == null) {
    // Use addError so Moqui marks the service call as failed and rolls back any DB work
    ec.message.addError("Party with ID '${partyId}' does not exist. " +
                        "Create a Party record first before adding a Person.")
    return
}

// ─────────────────────────────────────────────────────────────────────────────
// STEP 3: Create the Person record (spoke / extension table)
// ─────────────────────────────────────────────────────────────────────────────

def newPerson = ec.entity.makeValue("tutorial.party.Person")
newPerson.set("partyId",    partyId)
newPerson.set("firstName",  firstName)
newPerson.set("lastName",   lastName)

// dateOfBirth is optional — only set it if the caller provided it
if (dateOfBirth) {
    newPerson.set("dateOfBirth", dateOfBirth)
}

newPerson.create()    // executes: INSERT INTO person (party_id, first_name, last_name, ...) VALUES (...)

ec.logger.info("Person created → partyId: ${partyId}, name: ${firstName} ${lastName}")

// ─────────────────────────────────────────────────────────────────────────────
// STEP 4: Build and return the response message
// ─────────────────────────────────────────────────────────────────────────────
// Assigning to 'responseMessage' writes it to the out-parameter binding.
// Moqui reads this back and includes it in the service response.

responseMessage = "Person ${firstName} ${lastName} created successfully!"
