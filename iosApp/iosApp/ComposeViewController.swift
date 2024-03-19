//
//  ComposeViewController.swift
//  iosApp
//
//  Created by daichi-matsumoto on 2024/03/19.
//

import UIKit
import SwiftUI
import ComposeApp

struct ComposeViewController: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        initTools()

        return ApplicationKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}

    private func initTools() {
        InitHelperKt.doInitKoin()
        InitHelperKt.doInitCoil()
    }
}

