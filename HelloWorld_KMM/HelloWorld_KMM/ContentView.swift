//
//  ContentView.swift
//  HelloWorld_KMM
//
//  Created by Vitalii on 27.06.2022.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var viewModel: ContentViewModel
    
    var body: some View {
        NavigationView {
            
            VStack {
                Text(viewModel.greeting)
                    .padding()
                
                Text("""
        ID: \((viewModel.placeholder?.id).map { String($0) } ?? "N/A")
        UserID: \((viewModel.placeholder?.userId).map { String($0) } ?? "N/A")
        Title: \(viewModel.placeholder?.title ?? "N/A")
        Completed: \((viewModel.placeholder?.completed).map { String($0) } ?? "N/A")
        """)
                
                NavigationLink(destination: NavigationLazyView(ListView().environmentObject(ListViewModel()))) {
                    Text("Placeholders List")
                }
                .padding()
                .accentColor(Color.white)
                .background(Color(red: 239 / 255, green: 123 / 255, blue: 123 / 255, opacity: 1))
                .clipShape(Capsule())
                .padding()
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .navigationBarTitle("", displayMode: .inline)
            .navigationBarHidden(true)
            
        }
        
        .onAppear {
            viewModel.startMonitoring()
        }.onDisappear {
            viewModel.stopMonitoring()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView().environmentObject(ContentViewModel_Preview())
    }
}
