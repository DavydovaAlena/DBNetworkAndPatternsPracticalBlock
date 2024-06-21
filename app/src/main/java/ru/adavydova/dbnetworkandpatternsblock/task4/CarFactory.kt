package ru.adavydova.dbnetworkandpatternsblock.task4


interface CarFactory {
    fun getBody(): BodyFactory
    fun getLug(): Lug
    fun getSalon(): Salon

    interface BodyFactory {
        fun getBody(): String
    }

    interface Lug {
        fun getLug(): String
    }

    interface Salon {
        fun getSalon(): String
    }
}


class CarFactoryBuilder(): CarFactory {

    private var carFactoryBodyFactory: CarFactory.BodyFactory = MercedesFactory.MercedesBodyFactory()
    private var carFactoryLug: CarFactory.Lug = MercedesFactory.MercedesLag()
    private var carFactorySalon: CarFactory.Salon = MercedesFactory.MercedesSalon()

    override fun getBody(): CarFactory.BodyFactory {
        return carFactoryBodyFactory
    }

    override fun getLug(): CarFactory.Lug {
        return carFactoryLug
    }

    override fun getSalon(): CarFactory.Salon {
        return carFactorySalon
    }

    fun addCarBody(carFactoryBodyFactory: CarFactory.BodyFactory): CarFactoryBuilder {
        this.carFactoryBodyFactory = carFactoryBodyFactory
        return this
    }

    fun addCarLug(carFactoryLug: CarFactory.Lug): CarFactoryBuilder {
        this.carFactoryLug = carFactoryLug
        return this
    }

    fun addCarSalon(carFactorySalon: CarFactory.Salon): CarFactoryBuilder {
        this.carFactorySalon = carFactorySalon
        return this
    }

    fun build(): CarFactory{
        return this
    }

}


class MercedesFactory : CarFactory {

    override fun getBody(): CarFactory.BodyFactory {
        return MercedesBodyFactory()
    }

    override fun getLug(): CarFactory.Lug {
        return MercedesLag()
    }

    override fun getSalon(): CarFactory.Salon {
        return MercedesSalon()
    }

    class MercedesBodyFactory : CarFactory.BodyFactory {
        override fun getBody(): String {
            TODO("Not yet implemented")
        }
    }

    class MercedesLag : CarFactory.Lug {
        override fun getLug(): String {
            TODO("Not yet implemented")
        }
    }

    class MercedesSalon : CarFactory.Salon {
        override fun getSalon(): String {
            TODO("Not yet implemented")
        }
    }

}

class BMWFactory : CarFactory {

    override fun getBody(): CarFactory.BodyFactory {
        return BMWBodyFactory()
    }

    override fun getLug(): CarFactory.Lug {
        return BMWLag()
    }

    override fun getSalon(): CarFactory.Salon {
        return BMWSalon()
    }

    class BMWBodyFactory : CarFactory.BodyFactory {
        override fun getBody(): String {
            TODO("Not yet implemented")
        }
    }

    class BMWLag : CarFactory.Lug {
        override fun getLug(): String {
            TODO("Not yet implemented")
        }
    }

    class BMWSalon : CarFactory.Salon {
        override fun getSalon(): String {
            TODO("Not yet implemented")
        }
    }

}



