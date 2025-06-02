package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import vista.composeapp.generated.resources.Res
import vista.composeapp.generated.resources.compose_multiplatform

data class TechStackItem(
    val name: String,
    val description: String,
    val icon: ImageVector,
    val color: Color
)

data class FeatureItem(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen() {
    val platform = remember { Platform() }
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        platform.logSystemInfo()
        isVisible = true
    }

    val techStack = listOf(
        TechStackItem(
            name = "Kotlin Multiplatform",
            description = "Gemeinsame Geschäftslogik für alle Plattformen",
            icon = Icons.Default.Settings,
            color = MaterialTheme.colorScheme.primary
        ),
        TechStackItem(
            name = "Compose Multiplatform",
            description = "Moderne, deklarative UI-Entwicklung",
            icon = Icons.Default.Star,
            color = MaterialTheme.colorScheme.secondary
        ),
        TechStackItem(
            name = "Material Design 3",
            description = "Dynamisches Theming und moderne Komponenten",
            icon = Icons.Default.Info,
            color = MaterialTheme.colorScheme.tertiary
        )
    )

    val features = listOf(
        FeatureItem(
            title = "Cross-Platform",
            description = "Einmal entwickeln, überall verwenden",
            icon = Icons.Default.Phone,
            color = MaterialTheme.colorScheme.primary
        ),
        FeatureItem(
            title = "Performance",
            description = "Native Performance auf allen Plattformen",
            icon = Icons.Default.Star,
            color = MaterialTheme.colorScheme.secondary
        ),
        FeatureItem(
            title = "Modern UI",
            description = "Zeitgemäße Benutzeroberfläche mit Material 3",
            icon = Icons.Default.Info,
            color = MaterialTheme.colorScheme.tertiary
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // App Header
        item {
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(800)) + slideInVertically(
                    initialOffsetY = { -40 },
                    animationSpec = tween(800)
                )
            ) {
                AppHeaderCard()
            }
        }

        // Device Information
        item {
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(800, delayMillis = 200)) + slideInVertically(
                    initialOffsetY = { 40 },
                    animationSpec = tween(800, delayMillis = 200)
                )
            ) {
                DeviceInfoCard(platform = platform)
            }
        }

        // Technology Stack
        item {
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(800, delayMillis = 400)) + slideInVertically(
                    initialOffsetY = { 40 },
                    animationSpec = tween(800, delayMillis = 400)
                )
            ) {
                TechStackCard(techStack = techStack)
            }
        }

        // Features
        item {
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(800, delayMillis = 600)) + slideInVertically(
                    initialOffsetY = { 40 },
                    animationSpec = tween(800, delayMillis = 600)
                )
            ) {
                FeaturesCard(features = features)
            }
        }

        // About Section
        item {
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(800, delayMillis = 800)) + slideInVertically(
                    initialOffsetY = { 40 },
                    animationSpec = tween(800, delayMillis = 800)
                )
            ) {
                AboutCard()
            }
        }

        // Footer
        item {
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(animationSpec = tween(800, delayMillis = 1000))
            ) {
                FooterSection()
            }
        }
    }
}

@Composable
private fun AppHeaderCard() {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // App Icon with gradient background
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .background(
                        brush = androidx.compose.ui.graphics.Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        ),
                        shape = RoundedCornerShape(24.dp)
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.compose_multiplatform),
                    contentDescription = "Vista App Logo",
                    modifier = Modifier.size(64.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Text(
                text = "Vista",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Surface(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Version 1.0",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = "Moderne Kotlin Multiplatform Anwendung",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
            )
        }
    }
}

@Composable
private fun DeviceInfoCard(platform: Platform) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Geräteinformationen",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                DeviceInfoRow(
                    icon = Icons.Default.Phone,
                    label = "Plattform",
                    value = platform.name,
                    iconColor = MaterialTheme.colorScheme.primary
                )

                DeviceInfoRow(
                    icon = Icons.Default.Info,
                    label = "OS Version",
                    value = platform.osVersion,
                    iconColor = MaterialTheme.colorScheme.secondary
                )

                DeviceInfoRow(
                    icon = Icons.Default.Settings,
                    label = "Gerätemodell",
                    value = platform.deviceModel,
                    iconColor = MaterialTheme.colorScheme.tertiary
                )

                DeviceInfoRow(
                    icon = Icons.Default.Star,
                    label = "Display Dichte",
                    value = "${platform.density}x",
                    iconColor = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
private fun TechStackCard(techStack: List<TechStackItem>) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Technologie Stack",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                techStack.forEach { tech ->
                    TechStackRow(tech = tech)
                }
            }
        }
    }
}

@Composable
private fun FeaturesCard(features: List<FeatureItem>) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Features",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                features.forEach { feature ->
                    FeatureRow(feature = feature)
                }
            }
        }
    }
}

@Composable
private fun AboutCard() {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Über Vista",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            Text(
                text = "Vista demonstriert die Möglichkeiten von Kotlin Multiplatform Mobile durch die Kombination von gemeinsamer Geschäftslogik mit nativen Benutzeroberflächen. Die Anwendung nutzt Material Design 3 für ein modernes und konsistentes Benutzererlebnis über alle Plattformen hinweg.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify,
                lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.4,
                color = MaterialTheme.colorScheme.onSurface
            )

            Surface(
                color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = "Entwickelt mit modernen Technologien für optimale Performance und Wartbarkeit.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }
    }
}

@Composable
private fun DeviceInfoRow(
    icon: ImageVector,
    label: String,
    value: String,
    iconColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Surface(
                color = iconColor.copy(alpha = 0.12f),
                shape = CircleShape,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant,
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun TechStackRow(tech: TechStackItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Surface(
            color = tech.color.copy(alpha = 0.12f),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = tech.icon,
                contentDescription = null,
                tint = tech.color,
                modifier = Modifier.padding(12.dp)
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = tech.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = tech.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
private fun FeatureRow(feature: FeatureItem) {
    Surface(
        color = feature.color.copy(alpha = 0.08f),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                color = feature.color.copy(alpha = 0.2f),
                shape = CircleShape,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = feature.icon,
                    contentDescription = null,
                    tint = feature.color,
                    modifier = Modifier.padding(12.dp)
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = feature.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = feature.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Composable
private fun FooterSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "© 2025 Vista App",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            Text(
                text = "•",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
            )
            Text(
                text = "Made with ❤️",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }

        Text(
            text = "Powered by Kotlin Multiplatform",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
        )
    }
}