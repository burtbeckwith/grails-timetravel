package test

class TestDomainService {
    static transactional = true

    public insertDomainObject(String name, Integer value) {
        def domain = new TestDomain(name: name, value: value)
        domain.save()
    }
}