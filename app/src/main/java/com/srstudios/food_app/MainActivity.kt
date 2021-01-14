package com.srstudios.food_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    var adapter:FoodAdapter?=null
    var listofFoods=ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listofFoods.add(Food("coffee","There, legend says the goat herder Kaldi first discovered the potential of these beloved beans. The story goes that that Kaldi discovered coffee after he noticed that after eating the berries from a certain tree, his goats became so energetic that they did not want to sleep at night.",R.drawable.coffee_pot))
        listofFoods.add(Food("Expresso","The difference between coffee and espresso has to do with the method of preparation, starting with the beans themselves. Coffee beans designated for espresso are generally roasted for a longer amount of time than beans meant for drip coffee. Espresso beans are also ground on the finer side, more like sand than gravel.",R.drawable.espresso))
        listofFoods.add(Food("French fries","Some claim that fries originated in Belgium, where villagers along the River Meuse traditionally ate fried fish. ... It's said that this dish was discovered by American soldiers in Belgium during World War I and, since the dominant language of southern Belgium is French, they dubbed the tasty potatoes “French” fries.",R.drawable.french_fries))
        listofFoods.add(Food("Honey","The Antioxidants in It Are Linked to Other Beneficial Effects on Heart Health. Again, honey is a rich source of phenols and other antioxidant compounds. Many of these have been linked to a reduced risk of heart disease ( 8 ). They may help the arteries in your heart dilate, increasing blood flow to your heart.",R.drawable.honey))
        listofFoods.add(Food("Strawberry","Strawberries are bright red, juicy, and sweet. They're an excellent source of vitamin C and manganese and also contain decent amounts of folate (vitamin B9) and potassium. Strawberries are very rich in antioxidants and plant compounds, which may have benefits for heart health and blood sugar control ( 1 , 2 ).",R.drawable.strawberry_ice_cream))
        listofFoods.add(Food("Sugar cubes","Sugar, shaped in cubes usually measuring about ~4 grams each, often used for coffee or tea. Sugar cubes can be created to look roughly the same size but contain reduced sugar content through a special production process.",R.drawable.sugar_cubes))

        adapter= FoodAdapter(this,listofFoods)

        gridfoodlist.adapter=adapter




    }

       class FoodAdapter:BaseAdapter{

           var listofFood=ArrayList<Food>()
           var context:Context?=null
           constructor(context: Context,listofFood:ArrayList<Food>):super(){
               this.context=context
               this.listofFood=listofFood

           }
           override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
               val food=listofFood[position]
               var inflater=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
               var foodview=inflater.inflate(R.layout.food_ticket,null)
               foodview.foodimg.setImageResource(food.image!!)
               foodview.foodimg.setOnClickListener {
                   val intent =Intent(context,info::class.java)
                   intent.putExtra("name",food.name!!)
                   intent.putExtra("des",food.des!!)
                   intent.putExtra("image",food.image!!)
                   context!!.startActivity(intent)

               }
               foodview.foodtxt.text=food.name!!
               return foodview


           }

           override fun getItem(position: Int): Any {
              return listofFood[position]
           }

           override fun getItemId(position: Int): Long {
              return position.toLong()
           }

           override fun getCount(): Int {

               return listofFood.size
           }

       }








}
