import com.company.models.Gender
import com.company.models.Passenger
import com.company.models.Species
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.util.stream.Stream


fun main(args: Array<String>) {

    writePassengers()
    val file = FileReader("data.txt")
    val passengersString = file.readLines()
    file.close()

    val builder = GsonBuilder()
    val gson = builder.create()

    val passengerArray = gson.fromJson(passengersString[0], Array<Array<Passenger>>::class.java)

    var summaryAge = 0


    passengerArray.map {
        var age = 0
        it.forEach {
           age += it.age.toInt()
        }

        summaryAge += age/it.size
    }

    println("Average age: ${summaryAge / passengerArray.size}")

}

fun writePassengers() {
    val passengersSeat = listOf(
        listOf(
            Passenger("Ivan", "18", Gender.Male().gender, Species.European().species),
            Passenger("Ivanka", "22", Gender.Female().gender, Species.European().species),
            Passenger("Donald", "74", Gender.Male().gender, Species.European().species)
        ),
        listOf(
            Passenger("Ahmed", "31", Gender.Male().gender, Species.Arabic().species),
            Passenger("Andrew", "54", Gender.Male().gender, Species.European().species),
            Passenger("Angela", "18", Gender.Female().gender, Species.European().species)
        ),
        listOf(
            Passenger("Zinaida", "20", Gender.Female().gender, Species.Nigger().species),
            Passenger("Oleg", "21", Gender.Male().gender, Species.European().species),
            Passenger("Dmitry", "51", Gender.Male().gender, Species.European().species)
        ),
        listOf(
            Passenger("Abdulla", "27", Gender.Male().gender, Species.Arabic().species),
            Passenger("Fatima", "8", Gender.Female().gender, Species.Arabic().species),
            Passenger("Denis", "51", Gender.Male().gender, Species.Nigger().species)
        )


    )

    val gson = Gson()
    gson.toJson(passengersSeat)

    val file = FileWriter("data.txt")
    val passengersString = gson.toJson(passengersSeat)
    file.write(passengersString)
    file.close()
}

