package com.example.navigation_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedDemo by remember { mutableStateOf("Drawer") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Navigation Demo") },
                actions = {
                    DropdownMenuDemo(selectedDemo) { selectedDemo = it }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedDemo) {
                "Drawer" -> DrawerNavigationApp()
                "Bottom" -> BottomNavigationApp()
                "Tabs" -> TabNavigationApp()
            }
        }
    }
}

/* ----------------------- DROPDOWN MENU ----------------------- */
@Composable
fun DropdownMenuDemo(selectedDemo: String, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Menu")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            listOf("Drawer", "Bottom", "Tabs").forEach { item ->
                DropdownMenuItem(
                    text = {
                        if (item == selectedDemo) {
                            Text(item, fontWeight = FontWeight.Bold)
                        } else {
                            Text(item)
                        }
                    },
                    onClick = {
                        onSelect(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

/* ----------------------- 1. NAVIGATION DRAWER ----------------------- */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerNavigationApp() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    val screens = listOf("Home", "Favorites", "Settings")

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    "Navigation Drawer",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold
                )
                screens.forEach { screen ->
                    NavigationDrawerItem(
                        label = { Text(screen) },
                        selected = navController.currentDestination?.route == screen,
                        onClick = {
                            coroutineScope.launch { drawerState.close() }
                            navController.navigate(screen)
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Drawer Navigation") },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = "Home",
                modifier = Modifier.padding(padding)
            ) {
                composable("Home") { ScreenContent("🏠 Home Screen") }
                composable("Favorites") { ScreenContent("⭐ Favorites Screen") }
                composable("Settings") { ScreenContent("⚙️ Settings Screen") }
            }
        }
    }
}

/* ----------------------- 2. BOTTOM NAVIGATION ----------------------- */
@Composable
fun BottomNavigationApp() {
    val navController = rememberNavController()
    val items = listOf("Home", "Search", "Profile")

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                items.forEach { item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                when (item) {
                                    "Home" -> Icons.Default.Home
                                    "Search" -> Icons.Default.Search
                                    else -> Icons.Default.Person
                                },
                                contentDescription = null
                            )
                        },
                        label = { Text(item) },
                        selected = currentRoute == item,
                        onClick = { navController.navigate(item) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "Home",
            modifier = Modifier.padding(padding)
        ) {
            composable("Home") { ScreenContent("🏠 Home Screen") }
            composable("Search") { ScreenContent("🔍 Search Screen") }
            composable("Profile") { ScreenContent("👤 Profile Screen") }
        }
    }
}

/* ----------------------- 3. TABBED NAVIGATION ----------------------- */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabNavigationApp() {
    val tabs = listOf(
        "Latest",
        "Popular",
        "Trending",
        "Technology",
        "Sports",
        "Entertainment",
        "Business",
        "Health",
        "Science"
    )
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(title = { Text("Tabbed Navigation") })
                ScrollableTabRow(selectedTabIndex = selectedTab) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = selectedTab == index,
                            onClick = { selectedTab = index }
                        )
                    }
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            when (selectedTab) {
                0 -> Text("📰 Latest News", fontSize = 22.sp)
                1 -> Text("🌟 Popular Articles", fontSize = 22.sp)
                2 -> Text("🔥 Trending Topics", fontSize = 22.sp)
                3 -> Text("💻 Technology Updates", fontSize = 22.sp)
                4 -> Text("⚽ Sports Highlights", fontSize = 22.sp)
                5 -> Text("🎬 Entertainment News", fontSize = 22.sp)
                6 -> Text("💼 Business Reports", fontSize = 22.sp)
                7 -> Text("🏥 Health & Wellness", fontSize = 22.sp)
                8 -> Text("🔬 Science Discoveries", fontSize = 22.sp)
                else -> Text("Unknown Tab", fontSize = 22.sp)
            }
        }
    }
}

/* ----------------------- SHARED UI ----------------------- */
@Composable
fun ScreenContent(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text, fontSize = 22.sp)
    }
}
