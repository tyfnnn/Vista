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
    
    var body: some View {
        ScrollView {
            LazyVStack(spacing: 24) {
                // App Header Card
                VStack(spacing: 16) {
                    // App Icon
                    Image(systemName: "eye.fill")
                        .font(.system(size: 60))
                        .foregroundStyle(.blue)
                        .background(
                            Circle()
                                .fill(.blue.opacity(0.1))
                                .frame(width: 100, height: 100)
                        )
                    
                    // App Name and Version
                    Text("Vista")
                        .font(.largeTitle)
                        .fontWeight(.bold)
                        .foregroundStyle(.primary)
                    
                    Text("Version 1.0")
                        .font(.title3)
                        .foregroundStyle(.secondary)
                    
                    Text("Eine moderne Kotlin Multiplatform App")
                        .font(.body)
                        .multilineTextAlignment(.center)
                        .foregroundStyle(.secondary)
                        .padding(.horizontal)
                }
                .padding(24)
                .background(
                    RoundedRectangle(cornerRadius: 16)
                        .fill(.blue.opacity(0.08))
                        .stroke(.blue.opacity(0.2), lineWidth: 1)
                )
                
                // Device Information Card
                VStack(alignment: .leading, spacing: 16) {
                    HStack {
                        Image(systemName: "iphone")
                            .foregroundStyle(.blue)
                        Text("Geräteinformationen")
                            .font(.title2)
                            .fontWeight(.semibold)
                            .foregroundStyle(.primary)
                    }
                    
                    Divider()
                    
                    VStack(spacing: 12) {
                        DeviceInfoRow(label: "Plattform", value: platform.name)
                        DeviceInfoRow(label: "OS Version", value: platform.osVersion)
                        DeviceInfoRow(label: "Gerätemodell", value: platform.deviceModel)
                        DeviceInfoRow(label: "Display Dichte", value: "\(platform.density)x")
                    }
                }
                .padding(20)
                .background(
                    RoundedRectangle(cornerRadius: 12)
                        .fill(.gray.opacity(0.05))
                        .stroke(.gray.opacity(0.2), lineWidth: 1)
                )
                
                // Technology Stack Card
                VStack(alignment: .leading, spacing: 16) {
                    HStack {
                        Image(systemName: "hammer.fill")
                            .foregroundStyle(.orange)
                        Text("Technologie Stack")
                            .font(.title2)
                            .fontWeight(.semibold)
                            .foregroundStyle(.primary)
                    }
                    
                    Divider()
                    
                    VStack(spacing: 16) {
                        TechStackItem(
                            name: "Kotlin Multiplatform",
                            description: "Plattformübergreifende Entwicklung",
                            icon: "k.square.fill"
                        )
                        
                        TechStackItem(
                            name: "Compose Multiplatform",
                            description: "Moderne UI-Entwicklung",
                            icon: "rectangle.3.group.fill"
                        )
                        
                        TechStackItem(
                            name: "SwiftUI",
                            description: "Native iOS User Interface",
                            icon: "swift"
                        )
                        
                        TechStackItem(
                            name: "Material Design 3",
                            description: "Zeitgemäßes Design System",
                            icon: "paintpalette.fill"
                        )
                    }
                }
                .padding(20)
                .background(
                    RoundedRectangle(cornerRadius: 12)
                        .fill(.gray.opacity(0.05))
                        .stroke(.gray.opacity(0.2), lineWidth: 1)
                )
                
                // Platform Features Card
                VStack(alignment: .leading, spacing: 16) {
                    HStack {
                        Image(systemName: "star.fill")
                            .foregroundStyle(.yellow)
                        Text("iOS Features")
                            .font(.title2)
                            .fontWeight(.semibold)
                            .foregroundStyle(.primary)
                    }
                    
                    Divider()
                    
                    VStack(spacing: 12) {
                        FeatureRow(
                            icon: "icloud.fill",
                            title: "iCloud Integration",
                            description: "Nahtlose Synchronisation"
                        )
                        
                        FeatureRow(
                            icon: "bell.fill",
                            title: "Push Notifications",
                            description: "Intelligente Benachrichtigungen"
                        )
                        
                        FeatureRow(
                            icon: "lock.shield.fill",
                            title: "Privacy & Security",
                            description: "Datenschutz nach Apple Standards"
                        )
                        
                        FeatureRow(
                            icon: "accessibility.fill",
                            title: "Accessibility",
                            description: "Barrierefreie Bedienung"
                        )
                    }
                }
                .padding(20)
                .background(
                    RoundedRectangle(cornerRadius: 12)
                        .fill(.gray.opacity(0.05))
                        .stroke(.gray.opacity(0.2), lineWidth: 1)
                )
                
                // About Section
                VStack(alignment: .leading, spacing: 16) {
                    HStack {
                        Image(systemName: "info.circle.fill")
                            .foregroundStyle(.blue)
                        Text("Über Vista")
                            .font(.title2)
                            .fontWeight(.semibold)
                            .foregroundStyle(.primary)
                    }
                    
                    Divider()
                    
                    Text("Vista ist eine moderne, plattformübergreifende Anwendung, die mit Kotlin Multiplatform entwickelt wurde. Auf iOS nutzt sie SwiftUI für eine native Benutzererfahrung bei gleichzeitiger Nutzung gemeinsamer Geschäftslogik.")
                        .font(.body)
                        .lineLimit(nil)
                        .fixedSize(horizontal: false, vertical: true)
                        .foregroundStyle(.secondary)
                }
                .padding(20)
                .background(
                    RoundedRectangle(cornerRadius: 12)
                        .fill(.gray.opacity(0.05))
                        .stroke(.gray.opacity(0.2), lineWidth: 1)
                )
                
                // Copyright
                Text("© 2025 Vista App")
                    .font(.footnote)
                    .foregroundStyle(.tertiary)
                    .padding(.top, 16)
            }
            .padding(.horizontal, 24)
            .padding(.vertical, 16)
        }
        .navigationTitle("Über")
        .navigationBarTitleDisplayMode(.large)
        .onAppear {
            platform.logSystemInfo()
        }
    }
}

// MARK: - Supporting Views

struct DeviceInfoRow: View {
    let label: String
    let value: String
    
    var body: some View {
        HStack {
            Text(label)
                .font(.body)
                .foregroundStyle(.secondary)
            
            Spacer()
            
            Text(value)
                .font(.body)
                .fontWeight(.medium)
                .foregroundStyle(.primary)
        }
    }
}

struct TechStackItem: View {
    let name: String
    let description: String
    let icon: String
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: icon)
                .font(.title3)
                .foregroundStyle(.blue)
                .frame(width: 24)
            
            VStack(alignment: .leading, spacing: 2) {
                Text(name)
                    .font(.body)
                    .fontWeight(.medium)
                    .foregroundStyle(.primary)
                
                Text(description)
                    .font(.caption)
                    .foregroundStyle(.secondary)
            }
            
            Spacer()
        }
    }
}

struct FeatureRow: View {
    let icon: String
    let title: String
    let description: String
    
    var body: some View {
        HStack(spacing: 12) {
            Image(systemName: icon)
                .font(.title3)
                .foregroundStyle(.blue)
                .frame(width: 24)
            
            VStack(alignment: .leading, spacing: 2) {
                Text(title)
                    .font(.body)
                    .fontWeight(.medium)
                    .foregroundStyle(.primary)
                
                Text(description)
                    .font(.caption)
                    .foregroundStyle(.secondary)
            }
            
            Spacer()
        }
    }
}


#Preview {
    AboutView()
}
