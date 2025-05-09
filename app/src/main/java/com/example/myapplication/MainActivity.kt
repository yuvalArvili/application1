package com.example.myapplication
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.example.myapplication.logic.GameManager
import com.example.myapplication.utilites.SignalManager


class MainActivity : AppCompatActivity() {
    private lateinit var main_IMG_hearts: Array<AppCompatImageView>
    private lateinit var main_IMG_charcters: Array<AppCompatImageView>
    private lateinit var main_IMG_rocks: Array<Array<AppCompatImageView>>

    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var layout: RelativeLayout
    private lateinit var gameManager: GameManager

    private val maxColumns = 3
    private val maxRows = 8



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SignalManager.init(this)
        findViews()

        gameManager = GameManager(maxColumns,
            maxRows,
            main_IMG_rocks,
            main_IMG_hearts,
            main_IMG_charcters
        )
        game()

    }

    private fun findViews(){
        btnLeft = findViewById(R.id.main_BTN_left)
        btnRight = findViewById(R.id.main_BTN_right)
        layout = findViewById(R.id.main)

        main_IMG_hearts = arrayOf(
            findViewById(R.id.main_IMG_heart0),
            findViewById(R.id.main_IMG_heart1),
            findViewById(R.id.main_IMG_heart2)
        )
        main_IMG_charcters = arrayOf(
            findViewById(R.id.main_IMG_character0),
            findViewById(R.id.main_IMG_character1),
            findViewById(R.id.main_IMG_character2)
        )
        main_IMG_rocks = arrayOf(
           arrayOf( findViewById(R.id.cell_0_0),
           findViewById(R.id.cell_0_1),
           findViewById(R.id.cell_0_2)),

           arrayOf( findViewById(R.id.cell_1_0),
            findViewById(R.id.cell_1_1),
            findViewById(R.id.cell_1_2)),

            arrayOf(findViewById(R.id.cell_2_0),
            findViewById(R.id.cell_2_1),
            findViewById(R.id.cell_2_2)),

            arrayOf(findViewById(R.id.cell_3_0),
            findViewById(R.id.cell_3_1),
            findViewById(R.id.cell_3_2)),

            arrayOf(findViewById(R.id.cell_4_0),
            findViewById(R.id.cell_4_1),
            findViewById(R.id.cell_4_2)),

            arrayOf(findViewById(R.id.cell_5_0),
            findViewById(R.id.cell_5_1),
            findViewById(R.id.cell_5_2)),

            arrayOf(findViewById(R.id.cell_6_0),
            findViewById(R.id.cell_6_1),
            findViewById(R.id.cell_6_2)),

            arrayOf(findViewById(R.id.cell_7_0),
            findViewById(R.id.cell_7_1),
            findViewById(R.id.cell_7_2))
        )
    }

    private fun game() {
        gameManager.startGame()

        btnLeft.setOnClickListener {
            gameManager.movePlayerLeft()
        }

        btnRight.setOnClickListener {
            gameManager.movePlayerRight()
        }
    }
}








