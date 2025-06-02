//
//  AboutView.swift
//  iosApp
//
//  Created by Tayfun Ilker on 02.06.25.
//

import SwiftUI
import Shared

struct AboutView: View {
    @State private var platform = Platform()
    @Environment(\.dismiss) private var dismiss
    
    var body: some View {
        NavigationView {
            List {
                // App Header Section
                Section {
                    HStack {
                        // App Icon
                        RoundedRectangle(cornerRadius: 22, style: .continuous)
                            .fill(
                                LinearGradient(
                                    colors: [.blue, .cyan],
                                    startPoint: .topLeading,
                                    endPoint: .bottomTrailing
                                )
                            )
                            .frame(width: 80, height: 80)
                            .overlay {
                                Image(systemName: "eye.fill")
                                    .font(.system(size: 40, weight: .medium))
                                    .foregroundStyle(.white)
                            }
                        
                        VStack(alignment: .leading, spacing: 4) {
                            Text("Vista")
                                .font(.title2)
                                .fontWeight(.semibold)
                            
                            Text("Version 1.0")
                                .font(.subheadline)
                                .foregroundStyle(.secondary)
                            
                            Text("Kotlin Multiplatform")
                                .font(.caption)
                                .foregroundStyle(.tertiary)
                        }
                        
                        Spacer()
                    }
                    .padding(.vertical, 8)
                }
                .listRowBackground(Color.clear)
                
                // Device Information
                Section("Geräteinformationen") {
                    InfoRow(
                        icon: "iphone",
                        iconColor: .blue,
                        title: "Plattform",
                        value: platform.name
                    )
                    
                    InfoRow(
                        icon: "gear",
                        iconColor: .gray,
                        title: "iOS Version",
                        value: platform.osVersion
                    )
                    
                    InfoRow(
                        icon: "display",
                        iconColor: .purple,
                        title: "Gerätemodell",
                        value: platform.deviceModel
                    )
                    
                    InfoRow(
                        icon: "viewfinder",
                        iconColor: .orange,
                        title: "Display Dichte",
                        value: "\(platform.density)x"
                    )
                }
                
                // Technology Stack
                Section("Technologie Stack") {
                    TechRow(
                        icon: "k.square.fill",
                        iconColor: .purple,
                        title: "Kotlin Multiplatform",
                        subtitle: "Shared Business Logic"
                    )
                    
                    TechRow(
                        icon: "swift",
                        iconColor: .orange,
                        title: "SwiftUI",
                        subtitle: "Native iOS Interface"
                    )
                    
                    TechRow(
                        icon: "paintpalette.fill",
                        iconColor: .pink,
                        title: "Material Design 3",
                        subtitle: "Cross-Platform Design System"
                    )
                    
                    TechRow(
                        icon: "xcode",
                        iconColor: .blue,
                        title: "Xcode",
                        subtitle: "iOS Development Environment"
                    )
                }
                
                // iOS Features
                Section("iOS Features") {
                    FeatureRow(
                        icon: "icloud.fill",
                        iconColor: .blue,
                        title: "iCloud Integration",
                        subtitle: "Nahtlose Datensynchronisation"
                    )
                    
                    FeatureRow(
                        icon: "bell.badge.fill",
                        iconColor: .red,
                        title: "Push Notifications",
                        subtitle: "Intelligente Benachrichtigungen"
                    )
                    
                    FeatureRow(
                        icon: "faceid",
                        iconColor: .green,
                        title: "Biometric Authentication",
                        subtitle: "Face ID & Touch ID Support"
                    )
                    
                    FeatureRow(
                        icon: "accessibility",
                        iconColor: .blue,
                        title: "Accessibility",
                        subtitle: "VoiceOver & Dynamic Type"
                    )
                    
                    FeatureRow(
                        icon: "moon.fill",
                        iconColor: .indigo,
                        title: "Dark Mode",
                        subtitle: "Automatische Theme-Anpassung"
                    )
                }
                
                // App Information
                Section("Über Vista") {
                    VStack(alignment: .leading, spacing: 12) {
                        Text("Vista demonstriert die Möglichkeiten von Kotlin Multiplatform Mobile (KMM) durch die Kombination von gemeinsamer Geschäftslogik mit nativen iOS- und Android-Benutzeroberflächen.")
                            .font(.body)
                            .fixedSize(horizontal: false, vertical: true)
                        
                        Text("Diese iOS-Version nutzt SwiftUI für eine vollständig native Benutzererfahrung bei gleichzeitiger Nutzung der in Kotlin geschriebenen plattformübergreifenden Logik.")
                            .font(.body)
                            .foregroundStyle(.secondary)
                            .fixedSize(horizontal: false, vertical: true)
                    }
                    .padding(.vertical, 4)
                }
                
                // Links Section
                Section("Links") {
                    LinkRow(
                        icon: "globe",
                        iconColor: .blue,
                        title: "Kotlin Multiplatform",
                        subtitle: "kotlinlang.org"
                    )
                    
                    LinkRow(
                        icon: "hammer.fill",
                        iconColor: .orange,
                        title: "Compose Multiplatform",
                        subtitle: "compose-multiplatform.org"
                    )
                    
                    LinkRow(
                        icon: "swift",
                        iconColor: .orange,
                        title: "SwiftUI",
                        subtitle: "developer.apple.com"
                    )
                }
                
                // Footer
                Section {
                    HStack {
                        Spacer()
                        VStack(spacing: 4) {
                            Text("© 2025 Vista")
                                .font(.footnote)
                                .foregroundStyle(.secondary)
                            
                            Text("Made with ❤️ and Kotlin")
                                .font(.caption2)
                                .foregroundStyle(.tertiary)
                        }
                        Spacer()
                    }
                    .padding(.vertical)
                }
                .listRowBackground(Color.clear)
            }
            .navigationTitle("Über")
            .navigationBarTitleDisplayMode(.large)
            .toolbar {
                ToolbarItem(placement: .topBarTrailing) {
                    Button("Fertig") {
                        dismiss()
                    }
                    .fontWeight(.semibold)
                }
            }
        }
        .onAppear {
            platform.logSystemInfo()
        }
    }
}

// MARK: - Supporting Views

struct InfoRow: View {
    let icon: String
    let iconColor: Color
    let title: String
    let value: String
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: icon)
                .font(.title3)
                .foregroundStyle(iconColor)
                .frame(width: 24)
            
            Text(title)
                .font(.body)
            
            Spacer()
            
            Text(value)
                .font(.body)
                .foregroundStyle(.secondary)
        }
    }
}

struct TechRow: View {
    let icon: String
    let iconColor: Color
    let title: String
    let subtitle: String
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: icon)
                .font(.title2)
                .foregroundStyle(iconColor)
                .frame(width: 28)
            
            VStack(alignment: .leading, spacing: 2) {
                Text(title)
                    .font(.body)
                    .fontWeight(.medium)
                
                Text(subtitle)
                    .font(.caption)
                    .foregroundStyle(.secondary)
            }
            
            Spacer()
        }
        .padding(.vertical, 2)
    }
}

struct FeatureRow: View {
    let icon: String
    let iconColor: Color
    let title: String
    let subtitle: String
    
    var body: some View {
        HStack(spacing: 12) {
            ZStack {
                Circle()
                    .fill(iconColor.opacity(0.15))
                    .frame(width: 32, height: 32)
                
                Image(systemName: icon)
                    .font(.system(size: 16, weight: .semibold))
                    .foregroundStyle(iconColor)
            }
            
            VStack(alignment: .leading, spacing: 2) {
                Text(title)
                    .font(.body)
                    .fontWeight(.medium)
                
                Text(subtitle)
                    .font(.caption)
                    .foregroundStyle(.secondary)
            }
            
            Spacer()
        }
        .padding(.vertical, 4)
    }
}

struct LinkRow: View {
    let icon: String
    let iconColor: Color
    let title: String
    let subtitle: String
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: icon)
                .font(.title3)
                .foregroundStyle(iconColor)
                .frame(width: 24)
            
            VStack(alignment: .leading, spacing: 2) {
                Text(title)
                    .font(.body)
                    .fontWeight(.medium)
                
                Text(subtitle)
                    .font(.caption)
                    .foregroundStyle(.secondary)
            }
            
            Spacer()
            
            Image(systemName: "arrow.up.right")
                .font(.caption)
                .foregroundStyle(.tertiary)
        }
        .padding(.vertical, 2)
    }
}

// MARK: - Preview

struct AboutView_Previews: PreviewProvider {
    static var previews: some View {
        AboutView()
    }
}
