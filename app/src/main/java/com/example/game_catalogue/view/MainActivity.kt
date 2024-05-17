class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val welcome = Welcome(this)

        if (!welcome.isOpened()) {
            // If it's the first time opening the app, navigate to the Welcome fragment
            navController.navigate(R.id.welcomeFragment)

            // Mark the app as opened
            welcome.setOpened()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.gameListFragment, R.id.categoryListFragment, R.id.platformListFragment,R.id.welcomeFragment)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.gameListFragment) {
                navController.navigate(item.itemId, bundleOf(GameListFragment.ARG_MODE to 0))
            } else {
                navController.navigate(item.itemId)
            }
            true
        }
    }