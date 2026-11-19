package com.abir.education

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Blue = Color(0xFF1565C0)
private val LightBlue = Color(0xFFEAF3FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AbirApp()
            }
        }
    }
}

@Composable
fun AbirApp() {
    var page by remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = page == "Home",
                    onClick = { page = "Home" },
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("হোম") }
                )
                NavigationBarItem(
                    selected = page == "Courses",
                    onClick = { page = "Courses" },
                    icon = { Icon(Icons.Default.MenuBook, null) },
                    label = { Text("কোর্স") }
                )
                NavigationBarItem(
                    selected = page == "Exam",
                    onClick = { page = "Exam" },
                    icon = { Icon(Icons.Default.Quiz, null) },
                    label = { Text("পরীক্ষা") }
                )
                NavigationBarItem(
                    selected = page == "Profile",
                    onClick = { page = "Profile" },
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("প্রোফাইল") }
                )
            }
        },
        containerColor = Color(0xFFF5F8FF)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (page) {
                "Home" -> HomePage()
                "Courses" -> CoursesPage()
                "Exam" -> ExamPage()
                "Profile" -> ProfilePage()
            }
        }
    }
}

@Composable
fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Blue)
            .padding(22.dp)
    ) {
        Text(
            "ABIR EDUCATION",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "শিক্ষার নতুন ঠিকানা",
            color = Color.White,
            fontSize = 15.sp
        )
    }
}

@Composable
fun HomePage() {
    Header()

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                "স্বাগতম!",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Blue
            )
            Text("তোমার পড়াশোনা শুরু করো আজ থেকেই।")
        }

        item {
            InfoCard("📚", "অনলাইন কোর্স", "প্রথম থেকে দ্বাদশ শ্রেণির পড়াশোনা")
        }
        item {
            InfoCard("📝", "মডেল পরীক্ষা", "নিজের প্রস্তুতি যাচাই করো")
        }
        item {
            InfoCard("📖", "শিক্ষার নোট", "গুরুত্বপূর্ণ নোট ও পাঠ")
        }
        item {
            InfoCard("🏆", "ফলাফল", "পরীক্ষার ফলাফল দেখো")
        }
    }
}

@Composable
fun InfoCard(icon: String, title: String, subtitle: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(icon, fontSize = 32.sp)
            Spacer(Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(subtitle, color = Color.Gray, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun CoursesPage() {
    Header()
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("শ্রেণি নির্বাচন করো", fontSize = 22.sp,
                fontWeight = FontWeight.Bold)
        }
        items(12) { index ->
            InfoCard("🎓", "${index + 1}ম শ্রেণি", "পাঠ ও বিষয়সমূহ")
        }
    }
}

@Composable
fun ExamPage() {
    Header()
    Column(Modifier.padding(20.dp)) {
        Text("পরীক্ষা কেন্দ্র", fontSize = 24.sp,
            fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(15.dp))
        InfoCard("📝", "মডেল টেস্ট", "শিগগিরই চালু হবে")
        Spacer(Modifier.height(12.dp))
        InfoCard("🏆", "পরীক্ষার ফলাফল", "ফলাফল এখানে দেখা যাবে")
    }
}

@Composable
fun ProfilePage() {
    Header()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.AccountCircle,
            contentDescription = null,
            tint = Blue,
            modifier = Modifier.size(90.dp)
        )

        Text("শিক্ষার্থী প্রোফাইল",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Google দিয়ে লগইন")
        }

        Text(
            "Google লগইন এখনো সংযুক্ত করা হয়নি।",
            color = Color.Gray
        )
    }
}package com.abir.education

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Blue = Color(0xFF1565C0)
private val LightBlue = Color(0xFFEAF3FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AbirApp()
            }
        }
    }
}

@Composable
fun AbirApp() {
    var page by remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = page == "Home",
                    onClick = { page = "Home" },
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("হোম") }
                )
                NavigationBarItem(
                    selected = page == "Courses",
                    onClick = { page = "Courses" },
                    icon = { Icon(Icons.Default.MenuBook, null) },
                    label = { Text("কোর্স") }
                )
                NavigationBarItem(
                    selected = page == "Exam",
                    onClick = { page = "Exam" },
                    icon = { Icon(Icons.Default.Quiz, null) },
                    label = { Text("পরীক্ষা") }
                )
                NavigationBarItem(
                    selected = page == "Profile",
                    onClick = { page = "Profile" },
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("প্রোফাইল") }
                )
            }
        },
        containerColor = Color(0xFFF5F8FF)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (page) {
                "Home" -> HomePage()
                "Courses" -> CoursesPage()
                "Exam" -> ExamPage()
                "Profile" -> ProfilePage()
            }
        }
    }
}

@Composable
fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Blue)
            .padding(22.dp)
    ) {
        Text(
            "ABIR EDUCATION",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "শিক্ষার নতুন ঠিকানা",
            color = Color.White,
            fontSize = 15.sp
        )
    }
}

@Composable
fun HomePage() {
    Header()

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                "স্বাগতম!",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Blue
            )
            Text("তোমার পড়াশোনা শুরু করো আজ থেকেই।")
        }

        item {
            InfoCard("📚", "অনলাইন কোর্স", "প্রথম থেকে দ্বাদশ শ্রেণির পড়াশোনা")
        }
        item {
            InfoCard("📝", "মডেল পরীক্ষা", "নিজের প্রস্তুতি যাচাই করো")
        }
        item {
            InfoCard("📖", "শিক্ষার নোট", "গুরুত্বপূর্ণ নোট ও পাঠ")
        }
        item {
            InfoCard("🏆", "ফলাফল", "পরীক্ষার ফলাফল দেখো")
        }
    }
}

@Composable
fun InfoCard(icon: String, title: String, subtitle: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(icon, fontSize = 32.sp)
            Spacer(Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(subtitle, color = Color.Gray, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun CoursesPage() {
    Header()
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("শ্রেণি নির্বাচন করো", fontSize = 22.sp,
                fontWeight = FontWeight.Bold)
        }
        items(12) { index ->
            InfoCard("🎓", "${index + 1}ম শ্রেণি", "পাঠ ও বিষয়সমূহ")
        }
    }
}

@Composable
fun ExamPage() {
    Header()
    Column(Modifier.padding(20.dp)) {
        Text("পরীক্ষা কেন্দ্র", fontSize = 24.sp,
            fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(15.dp))
        InfoCard("📝", "মডেল টেস্ট", "শিগগিরই চালু হবে")
        Spacer(Modifier.height(12.dp))
        InfoCard("🏆", "পরীক্ষার ফলাফল", "ফলাফল এখানে দেখা যাবে")
    }
}

@Composable
fun ProfilePage() {
    Header()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.AccountCircle,
            contentDescription = null,
            tint = Blue,
            modifier = Modifier.size(90.dp)
        )

        Text("শিক্ষার্থী প্রোফাইল",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Google দিয়ে লগইন")
        }

        Text(
            "Google লগইন এখনো সংযুক্ত করা হয়নি।",
            color = Color.Gray
        )
    }
}package com.abir.education

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Blue = Color(0xFF1565C0)
private val LightBlue = Color(0xFFEAF3FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AbirApp()
            }
        }
    }
}

@Composable
fun AbirApp() {
    var page by remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = page == "Home",
                    onClick = { page = "Home" },
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("হোম") }
                )
                NavigationBarItem(
                    selected = page == "Courses",
                    onClick = { page = "Courses" },
                    icon = { Icon(Icons.Default.MenuBook, null) },
                    label = { Text("কোর্স") }
                )
                NavigationBarItem(
                    selected = page == "Exam",
                    onClick = { page = "Exam" },
                    icon = { Icon(Icons.Default.Quiz, null) },
                    label = { Text("পরীক্ষা") }
                )
                NavigationBarItem(
                    selected = page == "Profile",
                    onClick = { page = "Profile" },
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("প্রোফাইল") }
                )
            }
        },
        containerColor = Color(0xFFF5F8FF)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (page) {
                "Home" -> HomePage()
                "Courses" -> CoursesPage()
                "Exam" -> ExamPage()
                "Profile" -> ProfilePage()
            }
        }
    }
}

@Composable
fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Blue)
            .padding(22.dp)
    ) {
        Text(
            "ABIR EDUCATION",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "শিক্ষার নতুন ঠিকানা",
            color = Color.White,
            fontSize = 15.sp
        )
    }
}

@Composable
fun HomePage() {
    Header()

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                "স্বাগতম!",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Blue
            )
            Text("তোমার পড়াশোনা শুরু করো আজ থেকেই।")
        }

        item {
            InfoCard("📚", "অনলাইন কোর্স", "প্রথম থেকে দ্বাদশ শ্রেণির পড়াশোনা")
        }
        item {
            InfoCard("📝", "মডেল পরীক্ষা", "নিজের প্রস্তুতি যাচাই করো")
        }
        item {
            InfoCard("📖", "শিক্ষার নোট", "গুরুত্বপূর্ণ নোট ও পাঠ")
        }
        item {
            InfoCard("🏆", "ফলাফল", "পরীক্ষার ফলাফল দেখো")
        }
    }
}

@Composable
fun InfoCard(icon: String, title: String, subtitle: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(icon, fontSize = 32.sp)
            Spacer(Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(subtitle, color = Color.Gray, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun CoursesPage() {
    Header()
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("শ্রেণি নির্বাচন করো", fontSize = 22.sp,
                fontWeight = FontWeight.Bold)
        }
        items(12) { index ->
            InfoCard("🎓", "${index + 1}ম শ্রেণি", "পাঠ ও বিষয়সমূহ")
        }
    }
}

@Composable
fun ExamPage() {
    Header()
    Column(Modifier.padding(20.dp)) {
        Text("পরীক্ষা কেন্দ্র", fontSize = 24.sp,
            fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(15.dp))
        InfoCard("📝", "মডেল টেস্ট", "শিগগিরই চালু হবে")
        Spacer(Modifier.height(12.dp))
        InfoCard("🏆", "পরীক্ষার ফলাফল", "ফলাফল এখানে দেখা যাবে")
    }
}

@Composable
fun ProfilePage() {
    Header()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.AccountCircle,
            contentDescription = null,
            tint = Blue,
            modifier = Modifier.size(90.dp)
        )

        Text("শিক্ষার্থী প্রোফাইল",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Google দিয়ে লগইন")
        }

        Text(
            "Google লগইন এখনো সংযুক্ত করা হয়নি।",
            color = Color.Gray
        )
    }
}package com.abir.education

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Blue = Color(0xFF1565C0)
private val LightBlue = Color(0xFFEAF3FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AbirApp()
            }
        }
    }
}

@Composable
fun AbirApp() {
    var page by remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = page == "Home",
                    onClick = { page = "Home" },
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("হোম") }
                )
                NavigationBarItem(
                    selected = page == "Courses",
                    onClick = { page = "Courses" },
                    icon = { Icon(Icons.Default.MenuBook, null) },
                    label = { Text("কোর্স") }
                )
                NavigationBarItem(
                    selected = page == "Exam",
                    onClick = { page = "Exam" },
                    icon = { Icon(Icons.Default.Quiz, null) },
                    label = { Text("পরীক্ষা") }
                )
                NavigationBarItem(
                    selected = page == "Profile",
                    onClick = { page = "Profile" },
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("প্রোফাইল") }
                )
            }
        },
        containerColor = Color(0xFFF5F8FF)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (page) {
                "Home" -> HomePage()
                "Courses" -> CoursesPage()
                "Exam" -> ExamPage()
                "Profile" -> ProfilePage()
            }
        }
    }
}

@Composable
fun Header() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Blue)
            .padding(22.dp)
    ) {
        Text(
            "ABIR EDUCATION",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "শিক্ষার নতুন ঠিকানা",
            color = Color.White,
            fontSize = 15.sp
        )
    }
}

@Composable
fun HomePage() {
    Header()

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                "স্বাগতম!",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Blue
            )
            Text("তোমার পড়াশোনা শুরু করো আজ থেকেই।")
        }

        item {
            InfoCard("📚", "অনলাইন কোর্স", "প্রথম থেকে দ্বাদশ শ্রেণির পড়াশোনা")
        }
        item {
            InfoCard("📝", "মডেল পরীক্ষা", "নিজের প্রস্তুতি যাচাই করো")
        }
        item {
            InfoCard("📖", "শিক্ষার নোট", "গুরুত্বপূর্ণ নোট ও পাঠ")
        }
        item {
            InfoCard("🏆", "ফলাফল", "পরীক্ষার ফলাফল দেখো")
        }
    }
}

@Composable
fun InfoCard(icon: String, title: String, subtitle: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(icon, fontSize = 32.sp)
            Spacer(Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(subtitle, color = Color.Gray, fontSize = 13.sp)
            }
        }
    }
}

@Composable
fun CoursesPage() {
    Header()
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("শ্রেণি নির্বাচন করো", fontSize = 22.sp,
                fontWeight = FontWeight.Bold)
        }
        items(12) { index ->
            InfoCard("🎓", "${index + 1}ম শ্রেণি", "পাঠ ও বিষয়সমূহ")
        }
    }
}

@Composable
fun ExamPage() {
    Header()
    Column(Modifier.padding(20.dp)) {
        Text("পরীক্ষা কেন্দ্র", fontSize = 24.sp,
            fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(15.dp))
        InfoCard("📝", "মডেল টেস্ট", "শিগগিরই চালু হবে")
        Spacer(Modifier.height(12.dp))
        InfoCard("🏆", "পরীক্ষার ফলাফল", "ফলাফল এখানে দেখা যাবে")
    }
}

@Composable
fun ProfilePage() {
    Header()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.AccountCircle,
            contentDescription = null,
            tint = Blue,
            modifier = Modifier.size(90.dp)
        )

        Text("শিক্ষার্থী প্রোফাইল",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Google দিয়ে লগইন")
        }

        Text(
            "Google লগইন এখনো সংযুক্ত করা হয়নি।",
            color = Color.Gray
        )
    }
}
